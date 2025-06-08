package sky.group.homeworkgroup.logic;

import org.springframework.stereotype.Component;
import sky.group.homeworkgroup.model.InformationClient;
import sky.group.homeworkgroup.repository.ProjectRepository;


import java.util.UUID;

@Component
public class Logic {
    private final ProjectRepository projectRepository;

    public Logic(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public String analise(UUID id){
        String str = "";
        if ((numberOfReplenishmentOperations(id, "DEBIT") >= 1) && (numberOfReplenishmentOperations(id, "INVEST") == 0) &&
                (amountOfInvestments(id, "SAVING") >= 1000)) {
            str = "1 строка";
        }
        if ((numberOfReplenishmentOperations(id, "DEBIT") >= 1) && ((amountOfInvestments(id, "DEBIT") >= 50_000) ||
                (amountOfInvestments(id, "SAVING") >= 50_000)) &&
                (amountOfDepositsOfDebitType(id) >
                        (amountOfDebitTypeExpenses(id)))) {
            str = str + "2 строка";
        }
        if (numberOfLossOperations(id) == 0 &&
                amountOfDepositsOfDebitType(id) > (amountOfDebitTypeExpenses(id))
                && amountOfDebitTypeExpenses(id) > 100_000) {
            str = str + "3 строка";
        }
        return str;

    }
    private long numberOfReplenishmentOperations(UUID id, String type) {
        return projectRepository.getTransactionAmount(id).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(type)).count();
    }

    private long amountOfInvestments(UUID id, String type) {
        return projectRepository.getTransactionAmount(id).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(type)).mapToLong(InformationClient::getAmountTransaction).sum();
    }

    private long numberOfLossOperations(UUID id) {
        return projectRepository.getTransactionAmount(id).stream().filter(o -> o.getTypeTransaction()
                .equalsIgnoreCase("CREDIT")).count();
    }

    private long amountOfExpenses(UUID id, String type) {
        return projectRepository.getTransactionAmount(id).stream().filter(o -> o.getTypeTransaction()
                .equalsIgnoreCase(type)).mapToLong(InformationClient::getAmountTransaction).sum();
    }

    private long amountOfDepositsOfDebitType(UUID id) {
        return projectRepository.getTransactionAmount(id).stream().filter(o -> o.getTypeProduct()
                        .equalsIgnoreCase("DEBIT")).filter(o -> o.getTypeTransaction().equalsIgnoreCase("DEPOSIT"))
                .mapToLong(InformationClient::getAmountTransaction).sum();
    }

    private long amountOfDebitTypeExpenses(UUID id) {
        return projectRepository.getTransactionAmount(id).stream().filter(o -> o.getTypeProduct()
                        .equalsIgnoreCase("DEBIT")).filter(o -> !o.getTypeTransaction().equalsIgnoreCase("DEPOSIT"))
                .mapToLong(InformationClient::getAmountTransaction).sum();
    }
}
