package sky.group.homeworkgroup.service;

import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.repository.dynamic.DinamicReposytory;
import sky.group.homeworkgroup.repository.dynamic.RuleRepository;
import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model.model_dinamicbase.Rule;
import sky.group.homeworkgroup.service.logic.LogicDinamic;
import sky.group.homeworkgroup.service.request.DinamicService;

import java.util.*;

@Service
public class DinamicClientService {
    private final DinamicReposytory dinamicReposytory;
    private final RuleRepository ruleRepository;
    private final LogicDinamic logicDinamic;
    private final DinamicService dinamicService;

    public DinamicClientService(DinamicReposytory dinamicReposytory, RuleRepository ruleRepository, LogicDinamic logicDinamic, DinamicService dinamicService) {
        this.dinamicReposytory = dinamicReposytory;
        this.ruleRepository = ruleRepository;
        this.logicDinamic = logicDinamic;
        this.dinamicService = dinamicService;
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
                dinamicService.addStaticRuleList(contact.getKey());
            }
        }
        return recommendedProducts;
    }
}
