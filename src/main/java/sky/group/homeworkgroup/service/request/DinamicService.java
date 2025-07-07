package sky.group.homeworkgroup.service.request;

import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.repository.dynamic.DinamicReposytory;
import sky.group.homeworkgroup.repository.dynamic.RuleRepository;

import sky.group.homeworkgroup.model.model_dinamicbase.Rule;


import java.util.List;

/**
 * Класс, методы которого позволяют произвести запись, считывания и удаления информации по предлагаемому продукту.
 */

@Service
public class DinamicService {

    private final DinamicReposytory dinamicRepository;
    private final RuleRepository ruleRepository;

    public DinamicService(DinamicReposytory dinamicRepository, RuleRepository ruleRepository) {
        this.dinamicRepository = dinamicRepository;
        this.ruleRepository = ruleRepository;
    }

    public void deleteRule(Long id) {
        ruleRepository.deleteLineAllRule(id);
        dinamicRepository.deleteLine(id);
    }

    public Dinamic addDinamic(Dinamic argument) {
        Dinamic dinamic = dinamicRepository.save(argument);
        for (Rule variable : dinamic.getRule()) {
            ruleRepository.saveRule(variable.getArguments(), variable.getNegate(), variable.getQuery(), argument.getId());
        }
        ruleRepository.saveRuleCount(argument.getId());
        return dinamic;
    }

    public List<Dinamic> allAdvice() {
        return dinamicRepository.find();
    }
}
