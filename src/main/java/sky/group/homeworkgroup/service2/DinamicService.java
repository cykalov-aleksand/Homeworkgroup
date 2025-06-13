package sky.group.homeworkgroup.service2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.dinamicrepository.DinamicReposytory;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;


@Service
public class DinamicService {
    private final DinamicReposytory dinamicRepository;
    @Autowired
    public DinamicService(DinamicReposytory dinamicRepository) {
        this.dinamicRepository = dinamicRepository;
            }
    public Dinamic addDinamic(Dinamic argument){
    return dinamicRepository.save(argument);
     }

}
