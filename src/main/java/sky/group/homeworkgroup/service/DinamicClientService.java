package sky.group.homeworkgroup.service;

import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.exception.WhenNumberNotEqualOne;
import sky.group.homeworkgroup.model.InfoBuild;
import sky.group.homeworkgroup.model.modeljbd.UserParameters;
import sky.group.homeworkgroup.repository.ProjectRepository;
import sky.group.homeworkgroup.repository.dynamic.DinamicReposytory;
import sky.group.homeworkgroup.repository.dynamic.RuleRepository;
import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model.model_dinamicbase.Rule;
import sky.group.homeworkgroup.service.logic.LogicDinamic;

import java.util.*;

@Service
public class DinamicClientService {
    private final DinamicReposytory dinamicReposytory;
    private final RuleRepository ruleRepository;
    private final LogicDinamic logicDinamic;
    private final ProjectRepository projectRepository;
    private final BuildProperties buildProperties;

    public DinamicClientService(DinamicReposytory dinamicReposytory, RuleRepository ruleRepository,
                                LogicDinamic logicDinamic, ProjectRepository projectRepository,
                                BuildProperties buildProperties) {
        this.dinamicReposytory = dinamicReposytory;
        this.ruleRepository = ruleRepository;
        this.logicDinamic = logicDinamic;
        this.projectRepository = projectRepository;
        this.buildProperties = buildProperties;
    }

    public List<OutputData> searchForRecommendationsDinamic(UUID id) {
        Map<Long, List<Rule>> mapRule = new HashMap<>();
        List<OutputData> recommendedProducts = new ArrayList<>();
        // Map содержит в качестве ключа id продукта в таблиц dinamic поле id, и поле Мар содержит список методов по данному продукту
        for (Long variable : dinamicReposytory.idDinamic()) {
            mapRule.put(variable, ruleRepository.listRule(variable));
        }
        // Map содержит в качестве ключа id продукта в таблице dinamic поле id, и поле Мар содержит список методов по данному продукту
        for (Map.Entry<Long, List<Rule>> contact : mapRule.entrySet()) {
            // в цикле проходим по каждому продукту и проводим обработку советов в методе logicDinamic.dverificationOfComplianceWith(id -пользователя, список условий
            if (logicDinamic.dverificationOfComplianceWith(id, contact.getValue())) {
                Dinamic element = dinamicReposytory.findId(contact.getKey());
                recommendedProducts.add(new OutputData(UUID.fromString(element.getProductId()), element.getProductName(),
                        element.getProductText()));
                ruleRepository.addCount(contact.getKey());
                 }
        }
        return recommendedProducts;
    }

    public ResponseEntity<UserParameters> listLastFirstName(String userName){
        if (projectRepository.countUserName(userName)!=1) {
            // Выбрасываем собственное исключение, если b равно нулю
            throw new WhenNumberNotEqualOne();
        }
       UserParameters userParameters=projectRepository.findUserParameters(userName);
       searchForRecommendationsDinamic(userParameters.getId());
        return ResponseEntity.ok().body(userParameters);
    }
    public InfoBuild info() {
        return new InfoBuild("DinamicClientService", buildProperties.getVersion());
    }
}
