package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.group.homeworkgroup.exception.WhenNumberNotEqualOne;
import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.model.modeljbd.UserParameters;
import sky.group.homeworkgroup.service.ClientService;
import sky.group.homeworkgroup.service.DinamicClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
@Tag(name = "Контроллер SuggestionsForClient ", description = "Предназначен для работы с данными определенного клиента")
public class SuggestionsForClientController {
    private final ClientService serviceClients;
    private final DinamicClientService dinamicClientService;

    public SuggestionsForClientController(ClientService serviceClients, DinamicClientService dinamicClientService) {
        this.serviceClients = serviceClients;
        this.dinamicClientService = dinamicClientService;
    }

    @GetMapping("{user_Id}")
    @Operation(summary = "Вводим id клиента")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendations(@PathVariable @Parameter(description = "клиента",
            required = true) UUID user_Id) {
        return ResponseEntity.ok(Optional.of(serviceClients.searchForRecommendations(user_Id)));
    }

    @GetMapping("/dynamic/{user_Id}")
    @Operation(summary = "Вводим id клиента для динамического анализа")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendationsDinamic(@PathVariable @Parameter(description = "клиента",
            required = true) UUID user_Id) {
        return ResponseEntity.ok(Optional.of(dinamicClientService.searchForRecommendationsDinamic(user_Id)));
    }

    @GetMapping("/username/{userName}")
    @Operation(summary = "Вводим username клиента для динамического анализа")
    public ResponseEntity<UserParameters> listLastFirstName(@PathVariable @Parameter(description = "клиента", required = true) String userName) {
        return dinamicClientService.listLastFirstName(userName);
    }

    @ExceptionHandler(WhenNumberNotEqualOne.class)
    public ResponseEntity<String> whenNumberNotEqualOne
            (WhenNumberNotEqualOne e) {
        return ResponseEntity.status(204).body("");
    }
}
