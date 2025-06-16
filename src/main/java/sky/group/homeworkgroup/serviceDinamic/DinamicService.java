package sky.group.homeworkgroup.serviceDinamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sky.group.homeworkgroup.dinamicrepository.DinamicReposytory;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Set;


@Service
public class DinamicService {
    private final DinamicReposytory dinamicRepository;
    private final RuleRepository ruleRepository;


    public DinamicService(DinamicReposytory dinamicRepository, RuleRepository ruleRepository) {
        this.dinamicRepository = dinamicRepository;
        this.ruleRepository = ruleRepository;
    }

    Logger logger = LoggerFactory.getLogger(DinamicService.class);

    public Dinamic addDinamic(Dinamic argument) {
        Dinamic dinamic = dinamicRepository.save(argument);
        for (Rule variable : dinamic.getRule()) {
            ruleRepository.save(variable);
            ruleRepository.saveRule(dinamic.getId(), variable.getId());
        }
        return dinamic;
    }

    public void deleteRule(Long id) {
        ruleRepository.deleteLine(id);
        dinamicRepository.deleteLine(id);
    }

    public List<Dinamic> allAdvice() {
        return dinamicRepository.find();

    }
}


