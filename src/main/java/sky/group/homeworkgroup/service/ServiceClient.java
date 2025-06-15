package sky.group.homeworkgroup.service;

import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.service.logic.Logic;
import sky.group.homeworkgroup.model.OutputData;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ServiceClient {
        private final Logic logic;

    public ServiceClient(Logic logic) {
        this.logic = logic;
         }



    public List<OutputData> searchForRecommendations(UUID id) {
        Map<UUID, OutputData> recommendedProducts = new HashMap<>();
        recommendedProducts.put(UUID.fromString("147f6a0f-3b91-413b-ab99-87f081d60d5a"), new OutputData(UUID.fromString(
                "147f6a0f-3b91-413b-ab99-87f081d60d5a"), "Invest 500", textFile("text1.txt")));
        recommendedProducts.put(UUID.fromString("59efc529-2fff-41af-baff-90ccd7402925"), new OutputData(UUID.fromString(
                "59efc529-2fff-41af-baff-90ccd7402925"), "Top Saving", textFile("text2.txt")));
        recommendedProducts.put(UUID.fromString("ab138afb-f3ba-4a93-b74f-0fcee86d447f"), new OutputData(UUID.fromString(
                "ab138afb-f3ba-4a93-b74f-0fcee86d447f"), "Простой кредит", textFile("text3.txt")));
        return logic.analise(id).stream().map(recommendedProducts::get).toList();

    }
    private String textFile(String stroca) {
        BufferedReader reader = null;
        StringBuilder generalLine = new StringBuilder();
        try {
            reader = new BufferedReader(new FileReader("src/main/java/sky/group/homeworkgroup/" + stroca));
            String line;
            while ((line = reader.readLine()) != null) {
                generalLine.append(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия файла: " + e.getMessage());
            }
        }
        return generalLine.toString();
    }
}

