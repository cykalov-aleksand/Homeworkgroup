package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.group.homeworkgroup.model.OutputData;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.service.ServiceClient;

//import sky.group.homeworkgroup.service2.DinamicService;
//import sky.group.homeworkgroup.service2.DinamicService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
public class ControllerServiceClient {
    private final ServiceClient serviceClients;

    public ControllerServiceClient(ServiceClient serviceClients) {
        this.serviceClients = serviceClients;
         }

    @GetMapping("{user_Id}")
    @Operation(summary = "Вводим id клиента")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendations(@PathVariable UUID user_Id) {
        return ResponseEntity.ok(Optional.of(serviceClients.searchForRecommendations(user_Id)));
    }

      }
