package sky.group.homeworkgroup.serviceRule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sky.group.homeworkgroup.dinamicrepository.DinamicReposytory;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model_dinamicbase.Rule;
import sky.group.homeworkgroup.service.logic.LogicDinamic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DinamicService {

    private final DinamicReposytory dinamicRepository;
    private final RuleRepository ruleRepository;
    private final LogicDinamic logicDinamic;


    public DinamicService(DinamicReposytory dinamicRepository, RuleRepository ruleRepository, LogicDinamic logicDinamic) {
        this.dinamicRepository = dinamicRepository;
        this.ruleRepository = ruleRepository;
        this.logicDinamic = logicDinamic;
    }

    Logger logger = LoggerFactory.getLogger(DinamicService.class);

    public Dinamic addRule(Dinamic argument) {
        Dinamic dinamic = dinamicRepository.save(argument);
        for (Rule variable : dinamic.getRule()) {
            ruleRepository.save(variable);
            ruleRepository.saveRule(dinamic.getId(), variable.getId());
        }
        return dinamic;
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

    public List<Rule> allAdvice(Long idProduct) {
        Map<Long, List<Rule>> mapRule = new HashMap<>();
        for (Long variable : dinamicRepository.idDinamic()) {
            mapRule.put(variable, ruleRepository.listRule(variable));
        }
        return mapRule.get(idProduct);
    }

    public Dinamic addDinamic(Dinamic argument) {
        Dinamic dinamic = dinamicRepository.save(argument);
        for (Rule variable : dinamic.getRule()) {
            ruleRepository.saveRile(variable.getArguments(), variable.getNegate(), variable.getQuery(), argument.getId());
        }
        return dinamic;
    }
}


