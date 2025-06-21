package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.service.ClientService;
import sky.group.homeworkgroup.service.DinamicClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
public class SuggestionsForClientController {
    private final ClientService serviceClients;
    private final DinamicClientService dinamicClientService;

    public SuggestionsForClientController(ClientService serviceClients, DinamicClientService dinamicClientService) {
        this.serviceClients = serviceClients;
        this.dinamicClientService = dinamicClientService;
    }

    @GetMapping("{user_Id}")
    @Operation(summary = "Вводим id клиента")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendations(@PathVariable UUID user_Id) {
        return ResponseEntity.ok(Optional.of(serviceClients.searchForRecommendations(user_Id)));
    }

    @GetMapping("/dynamic/{user_Id}")
    @Operation(summary = "Вводим id клиента для динамического анализа")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendationsDinamic(@PathVariable UUID user_Id) {
        return ResponseEntity.ok(Optional.of(dinamicClientService.searchForRecommendationsDinamic(user_Id)));
    }
}
