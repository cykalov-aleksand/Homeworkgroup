package sky.group.homeworkgroup.service.request;

import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.model.InfoBuild;
import sky.group.homeworkgroup.model.model_dinamicbase.Rule;
import sky.group.homeworkgroup.model.model_dinamicbase.Statistic;
import sky.group.homeworkgroup.repository.dynamic.DinamicReposytory;
import sky.group.homeworkgroup.repository.dynamic.RuleRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RuleService {
    private final RuleRepository ruleRepository;
    private final DinamicReposytory dinamicReposytory;
    private final BuildProperties buildProperties;

    public RuleService(RuleRepository ruleRepository, DinamicReposytory dinamicReposytory, BuildProperties buildProperties) {
        this.ruleRepository = ruleRepository;
        this.dinamicReposytory = dinamicReposytory;
        this.buildProperties = buildProperties;
    }

    public List<Rule> allAdvice(Long idProduct) {
        Map<Long, List<Rule>> mapRule = new HashMap<>();
        for (Long variable : dinamicReposytory.idDinamic()) {
            mapRule.put(variable, ruleRepository.listRule(variable));
        }
        return mapRule.get(idProduct);
    }

    public String deleteRule(Long idProduct, Long idRule) {
        for (Rule variable : ruleRepository.listRule(idProduct)) {
            if (idRule.equals(variable.getId())) {
                ruleRepository.deleteLineRule(idRule);
                return "Строка удалена";
            }
        }
        return "рекомендация с id=" + idRule + " не принадлежит продукту с Id= " + idRule;
    }
    public List<Statistic>listStatic(){
        return ruleRepository.findCount();
    }
    public InfoBuild info() {
        return new InfoBuild("request/RuleService", buildProperties.getVersion());
    }
}
