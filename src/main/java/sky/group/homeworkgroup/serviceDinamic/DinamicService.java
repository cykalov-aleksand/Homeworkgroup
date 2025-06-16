package sky.group.homeworkgroup.serviceDinamic;

import org.springframework.stereotype.Service;

import sky.group.homeworkgroup.dinamicrepository.DinamicReposytory;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;


@Service
public class DinamicService {
    private final DinamicReposytory dinamicRepository;
    private final RuleRepository ruleRepository;


    public DinamicService(DinamicReposytory dinamicRepository, RuleRepository ruleRepository) {
        this.dinamicRepository = dinamicRepository;
        this.ruleRepository = ruleRepository;
    }

    public Dinamic addDinamic(Dinamic argument) {
        Dinamic dinamic = dinamicRepository.save(argument);
           for (Rule variable : dinamic.getRule()) {
            //SaveRule выбрасывает ошибку запрос не вернулся
            try {
                System.err.println(variable.getId());
               ruleRepository.save(variable);
                System.err.println(variable.getId());
               ruleRepository.saveRule(dinamic.getId(), variable.getId());
            } catch (Exception ignored) {
                System.err.println("error");
            }
        }
        return dinamic;
    }
    public void deleteRule(Long id) {
        try{
        ruleRepository.deleteLine(id);
            } catch (Exception ignored) {

        }
        try{
           dinamicRepository.deleteLine(id);
        } catch (Exception ignored) {

        }
        }
        public List<Dinamic> allAdvice(){
        return dinamicRepository.find();

        }
}


