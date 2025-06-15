package sky.group.homeworkgroup.serviceDinamic;

import org.springframework.stereotype.Service;

import sky.group.homeworkgroup.dinamicrepository.DinamicReposytory;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.util.List;


@Service
public class DinamicService {
    private final DinamicReposytory dinamicRepository;
    private final RuleRepository ruleRepository;


    public DinamicService(DinamicReposytory dinamicRepository, RuleRepository ruleRepository) {
        this.dinamicRepository = dinamicRepository;
        this.ruleRepository = ruleRepository;
         }

    public Dinamic addDinamic(Dinamic argument) {
       Dinamic dinamic=dinamicRepository.save(argument);
        List<Rule> rule=dinamic.getRule().stream().map(ruleRepository::save).toList();
        return dinamic;
    }

public void deleteRule(Long id){
dinamicRepository.deleteById(id);
}
    }


