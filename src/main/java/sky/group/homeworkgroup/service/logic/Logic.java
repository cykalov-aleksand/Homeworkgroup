package sky.group.homeworkgroup.service.logic;

import org.springframework.stereotype.Component;
import sky.group.homeworkgroup.model.modeljbd.InformationClient;
import sky.group.homeworkgroup.repository.ProjectRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class Logic {
    private final ProjectRepository projectRepository;

    public Logic(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<UUID> analise(UUID id) {
        List<UUID> list = new ArrayList<>();
        if ((numberOfReplenishmentOperations(id, "DEBIT") >= 1) && (numberOfReplenishmentOperations(id, "INVEST") == 0) &&
                (amountOfInvestments(id, "SAVING") >= 1000)) {
            list.add(UUID.fromString("147f6a0f-3b91-413b-ab99-87f081d60d5a"));
        }
        if ((numberOfReplenishmentOperations(id, "DEBIT") >= 1) && ((amountOfInvestments(id, "DEBIT") >= 50_000) ||
                (amountOfInvestments(id, "SAVING") >= 50_000)) &&
                (amountOfDepositsOfDebitType(id) >
                        (amountOfDebitTypeExpenses(id)))) {
            list.add(UUID.fromString("59efc529-2fff-41af-baff-90ccd7402925"));
        }

        if (numberOfLossOperations(id) == 0 &&
                amountOfDepositsOfDebitType(id) > (amountOfDebitTypeExpenses(id))
                && amountOfDebitTypeExpenses(id) > 100_000) {
            list.add(UUID.fromString("ab138afb-f3ba-4a93-b74f-0fcee86d447f"));
        }
        return list;
    }

    private long numberOfReplenishmentOperations(UUID id, String type) {
        return projectRepository.getListTransactions(id).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(type)).count();
    }

    private long amountOfInvestments(UUID id, String type) {
        return projectRepository.getListTransactions(id).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(type)).mapToLong(InformationClient::getAmountTransaction).sum();
    }

    private long numberOfLossOperations(UUID id) {
        return projectRepository.getListTransactions(id).stream().filter(o -> o.getTypeTransaction()
                .equalsIgnoreCase("CREDIT")).count();
    }

    private long amountOfDepositsOfDebitType(UUID id) {
        return projectRepository.getListTransactions(id).stream().filter(o -> o.getTypeProduct()
                        .equalsIgnoreCase("DEBIT")).filter(o -> o.getTypeTransaction().equalsIgnoreCase("DEPOSIT"))
                .mapToLong(InformationClient::getAmountTransaction).sum();
    }

    private long amountOfDebitTypeExpenses(UUID id) {
        return projectRepository.getListTransactions(id).stream().filter(o -> o.getTypeProduct()
                        .equalsIgnoreCase("DEBIT")).filter(o -> !o.getTypeTransaction().equalsIgnoreCase("DEPOSIT"))
                .mapToLong(InformationClient::getAmountTransaction).sum();
    }

}
