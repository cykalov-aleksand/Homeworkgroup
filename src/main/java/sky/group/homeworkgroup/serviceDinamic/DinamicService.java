package sky.group.homeworkgroup.serviceDinamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sky.group.homeworkgroup.dinamicrepository.DinamicReposytory;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;

import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model_dinamicbase.Rule;
import sky.group.homeworkgroup.serviceDinamic.logic.LogicDinamic;
//import sky.group.homeworkgroup.serviceDinamic.logic.Logic;

import java.sql.SQLException;
import java.util.*;


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
    public List<OutputData> searchForRecommendations(UUID id) {
Map<Long,List<Rule>> mapRule=new HashMap<>();
        System.out.println(dinamicRepository.idDinamic());
        for(Long variable:dinamicRepository.idDinamic()){
            mapRule.put(variable,ruleRepository.listRule(variable));
        }
        for (Map.Entry<Long, List<Rule>> contact: mapRule.entrySet()) {
            logicDinamic.dverificationOfComplianceWith(id,contact.getValue());
                    }






List<OutputData>sss=new ArrayList<>();
        return sss;
    }
}


