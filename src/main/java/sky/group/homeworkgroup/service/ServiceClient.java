package sky.group.homeworkgroup.service;

import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.logic.Logic;
import sky.group.homeworkgroup.model.InformationClient;
import sky.group.homeworkgroup.repository.ProjectRepository;

import java.util.Collection;
import java.util.UUID;

@Service
public class ServiceClient {
    private final ProjectRepository projectRepository;
    private final Logic logic;

    public ServiceClient(ProjectRepository projectRepository, Logic logic) {
        this.projectRepository = projectRepository;
        this.logic = logic;
    }

    public String user(UUID id) {
        return logic.analise(id);
       }

    public Collection<InformationClient> print(UUID id) {
        return projectRepository.getTransactionAmount(id);
    }

   }
