package sky.group.homeworkgroup.service;

import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.model.InformationClient;
import sky.group.homeworkgroup.repository.ProjectRepository;

import java.util.Collection;
import java.util.UUID;

@Service
public class ServiceClient {
   private final ProjectRepository projectRepository;

    public ServiceClient(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public String user(UUID id) {
        return projectRepository.getRandomTransactionAmount(id);
    }
    public Collection<InformationClient> print(UUID id){
       return projectRepository.getTransactionAmount(id);
    }
    private long numberOfReplenishmentOperations(UUID id,String type){
       return projectRepository.getTransactionAmount(id).stream().filter(o->o.getTypeProduct()
               .equalsIgnoreCase(type)).count();
    }
    private long amountOfInvestments(UUID id,String type){
         return projectRepository.getTransactionAmount(id).stream().filter(o->o.getTypeProduct()
                .equalsIgnoreCase(type)).mapToLong(InformationClient::getAmountTransaction).sum();
    }
    private long numberOfLossOperations(UUID id,String type){
     return projectRepository.getTransactionAmount(id).stream().filter(o->o.getTypeTransaction()
             .equalsIgnoreCase(type)).count();
    }
    private long amountOfExpenses(UUID id,String type){
        return projectRepository.getTransactionAmount(id).stream().filter(o->o.getTypeTransaction()
                .equalsIgnoreCase(type)).mapToLong(InformationClient::getAmountTransaction).sum();
    }
}
