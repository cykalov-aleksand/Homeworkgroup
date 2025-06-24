package sky.group.homeworkgroup.service.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sky.group.homeworkgroup.model.StaticRuleModel;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.repository.dynamic.DinamicReposytory;
import sky.group.homeworkgroup.repository.dynamic.RuleRepository;

import sky.group.homeworkgroup.model.model_dinamicbase.Rule;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DinamicService {

    private final DinamicReposytory dinamicRepository;
    private final RuleRepository ruleRepository;


    public DinamicService(DinamicReposytory dinamicRepository, RuleRepository ruleRepository) {
        this.dinamicRepository = dinamicRepository;
        this.ruleRepository = ruleRepository;
    }

    Logger logger = LoggerFactory.getLogger(DinamicService.class);

    public Map<Long,StaticRuleModel> staticRuleList=new HashMap<>();

    public void deleteRule(Long id) {
        ruleRepository.deleteLineAllRule(id);
        dinamicRepository.deleteLine(id);
        staticRuleList.remove(id);
    }

    public Dinamic addDinamic(Dinamic argument) {
        Dinamic dinamic = dinamicRepository.save(argument);
        staticRuleList.put(dinamic.getId(), new StaticRuleModel(dinamic.getId(),0));
        for (Rule variable : dinamic.getRule()) {
            ruleRepository.saveRile(variable.getArguments(), variable.getNegate(), variable.getQuery(), argument.getId());
             }
        return dinamic;
    }

    public List<Dinamic> allAdvice() {
        List<Dinamic>advices= dinamicRepository.find();
        advices.stream().map(o->staticRuleList.put(o.getId(),new StaticRuleModel(o.getId(),0)));
        return advices;
    }
    public void addStaticRuleList(Long id){
       int count= staticRuleList.get(id).getCount()+1;
       staticRuleList.put(id,new StaticRuleModel(id,count));
    }
    public List<StaticRuleModel>staticRuleAll(){
        return staticRuleList.values().stream().toList();
    }
}


