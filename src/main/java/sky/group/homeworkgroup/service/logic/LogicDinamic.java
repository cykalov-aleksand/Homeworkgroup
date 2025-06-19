package sky.group.homeworkgroup.service.logic;

import org.springframework.stereotype.Component;
import sky.group.homeworkgroup.dinamicrepository.RuleRepository;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class LogicDinamic {
    private final RuleRepository ruleRepository;

    public LogicDinamic(RuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    public Boolean dverificationOfComplianceWith(UUID client, List<Rule> condition) {
        // проходим по каждому условию и переходим к анализу в определенном методе
        Boolean resultat = true;
        List<Boolean> listResult = new ArrayList<>();
        for (Rule variable : condition) {
            List<String> list = convertingStringToList(variable.getArguments().get(0));
            switch (variable.getQuery().toUpperCase().trim()) {
                case ("USER_OF"):
                    listResult.add(analizingUserOf(list.get(0)));
                    break;
                case ("ACTIVE_USER_OF"):
                    listResult.add(analizingActiveUserOf(list.get(0)));
                    break;
                case ("TRANSACTION_SUM_COMPARE"):
                    listResult
                            .add(analisingTransactionSumCompare(list.get(0), list.get(1), list.get(2), list.get(3)));
                    break;
                case ("TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW"):
                    listResult.add(analizingTransactionSumCompareDepositWithDraw(
                            list.get(0), list.get(1)));
                    break;
            }
        }
        for (int number = 0; number < listResult.size(); number++) {
            resultat = listResult.get(number) && resultat;
        }
        return resultat;
    }

    private Boolean analizingUserOf(String typeTransaction) {
        System.out.println("\nТип запроса  USER_OF");
        System.out.println("typeTransaction = " + typeTransaction);
        return true;
    }

    private Boolean analizingActiveUserOf(String typeTransaction) {
        System.out.println("\nТип запроса  ACTIVE_USER_OF");
        System.out.println("typeTransaction = " + typeTransaction);

        return true;
    }

    private Boolean analisingTransactionSumCompare(String typeProduct, String typeTransaction, String comparisonOperation, String stringNumber) {
        System.out.println("\nТип запроса  TRANSACTION_SUM_COMPARE");
        System.out.println("typeProduct = " + typeProduct);
        System.out.println("tipeTransaction = " + typeTransaction);
        System.out.println("comparisonOperation = " + comparisonOperation);
        System.out.println("stringNumber = " + stringNumber);


        return true;
    }

    private Boolean analizingTransactionSumCompareDepositWithDraw(String typeTransaction, String comparisonOperation) {
        System.out.println("\nТип запроса  TRANSACTION_SUM_COMPARE_DEPOSIT_WITHDRAW");
        System.out.println("typeTransaction = " + typeTransaction);
        System.out.println("comparisonOperation = " + comparisonOperation);
        return true;
    }

    private List<String> convertingStringToList(String string) {
        String string1=string.replace("(","");
        string=string1.replace(")","");
        List<String>ss= Arrays.stream(string.split(",")).toList();
        System.err.println(ss);
        return ss;
    }
}


