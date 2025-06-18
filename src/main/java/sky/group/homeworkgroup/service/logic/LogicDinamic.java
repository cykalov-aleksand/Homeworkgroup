package sky.group.homeworkgroup.service.logic;

import org.springframework.stereotype.Component;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.util.List;
import java.util.UUID;

@Component
public class LogicDinamic {
    private final RuleRepository ruleRepository;

    public LogicDinamic(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public Boolean dverificationOfComplianceWith(UUID client, List<Rule>condition){
        System.out.println(condition);
        return true;
    }
}
