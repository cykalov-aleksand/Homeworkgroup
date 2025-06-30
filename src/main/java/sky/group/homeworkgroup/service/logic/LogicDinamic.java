package sky.group.homeworkgroup.service.logic;

import org.springframework.stereotype.Component;
import sky.group.homeworkgroup.model.modeljbd.InformationClient;
import sky.group.homeworkgroup.model.model_dinamicbase.Rule;
import sky.group.homeworkgroup.repository.ProjectRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class LogicDinamic {
    private final ProjectRepository projectRepository;

    public LogicDinamic(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    /**
     * Производим анализ выполнения условия описанного в таблице rule для клиента с id номером (client)
     */
    public Boolean dverificationOfComplianceWith(UUID client, List<Rule> condition) {
        // проходим по каждому условию и переходим к анализу в определенном методе
        Boolean resultat = true;
        List<Boolean> listResult = new ArrayList<>();
        for (Rule variable : condition) {
            List<String> list = convertingStringToList(variable.getArguments().get(0));
            switch (variable.getQuery().toUpperCase().trim()) {
                case ("USER_OF"):
                    listResult.add(analyzingUserOf(client, list.get(0), variable.getNegate()));
                    break;
                case ("ACTIVE_USER_OF"):
                    listResult.add(analyzingActiveUserOf(client, list.get(0), variable.getNegate()));
                    break;
                case ("TRANSACTION_SUM_COMPARE"):
                    listResult
                            .add(analysingTransactionSumCompare(client, list.get(0), list.get(1), list.get(2),
                                    list.get(3), variable.getNegate()));
                    break;
                case ("TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW"):
                    listResult.add(analyzingTransactionSumCompareDepositWithDraw(client, list.get(0), list.get(1),
                            variable.getNegate()));
                    break;
            }
        }
        for (Boolean aBoolean : listResult) {
            resultat = aBoolean && resultat;
        }
        return resultat;
    }

    /**
     * Метод проверки соблюдения условия USER_OF
     */
    private Boolean analyzingUserOf(UUID clientId, String typeTransaction, Boolean negate) {
        boolean truthCheck;
        truthCheck = projectRepository.getListTransactions(clientId).stream().anyMatch(o -> o.getTypeProduct()
                .equalsIgnoreCase(typeTransaction));
        return truthCheck == negate;
    }

    /**
     * Метод проверки соблюдения условия ACTIVE_USER_OF
     */
    private Boolean analyzingActiveUserOf(UUID clientId, String typeTransaction, Boolean negate) {
        boolean truthCheck;
        truthCheck = projectRepository.getListTransactions(clientId).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(typeTransaction)).count() >= 5;
        return truthCheck == negate;
    }

    /**
     * Метод проверки соблюдения условия TRANSACTION_SUM_COMPARE
     */
    private Boolean analysingTransactionSumCompare(UUID clientId, String typeProduct, String typeTransaction,
                                                   String comparisonOperation, String stringNumber, Boolean negate) {
        long number = Long.parseLong(stringNumber);
        long amount = projectRepository.getListTransactions(clientId).stream().filter(o -> o.getTypeProduct()
                        .equalsIgnoreCase(typeProduct)).filter(o -> o.getTypeTransaction().equalsIgnoreCase(typeTransaction))
                .mapToLong(InformationClient::getAmountTransaction).sum();
        boolean truthCheck = compareNumber(comparisonOperation, amount, number);
        return truthCheck == negate;
    }

    /**
     * Метод проверки соблюдения условия TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW
     */
    private Boolean analyzingTransactionSumCompareDepositWithDraw(UUID clientId, String typeTransaction,
                                                                  String comparisonOperation, Boolean negate) {
        long deposit, withdraw;
        deposit = projectRepository.getListTransactions(clientId).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(typeTransaction)).filter(o -> o.getTypeTransaction()
                .equalsIgnoreCase("DEPOSIT")).mapToLong(InformationClient::getAmountTransaction).sum();
        withdraw = projectRepository.getListTransactions(clientId).stream().filter(o -> o.getTypeProduct()
                .equalsIgnoreCase(typeTransaction)).filter(o -> o.getTypeTransaction()
                .equalsIgnoreCase("WITHDRAW")).mapToLong(InformationClient::getAmountTransaction).sum();
        boolean truthCheck = compareNumber(comparisonOperation, deposit, withdraw);
        return truthCheck == negate;
    }

    /**
     * Метод преобразования колонки "argument" из строки в список
     */
    private List<String> convertingStringToList(String string) {
        String line = string.replace("(", "").replace(")", "");
        return Arrays.stream(line.split(",")).toList();
    }

    /**
     * Преобразование строки в значение операции
     */
    private boolean compareNumber(String operator, long number1, long number2) {
        switch (operator) {
            case (">"):
                if (number1 > number2) {
                    return true;
                }
                break;
            case ("<"):
                if (number1 < number2) {
                    return true;
                }
                break;
            case ("<="):
                if (number1 <= number2) {
                    return true;
                }
                break;
            case (">="):
                if (number1 >= number2) {
                    return true;
                }
                break;
            case ("=="):
                if (number1 == number2) {
                    return true;
                }
                break;
        }
        return false;
    }
}



