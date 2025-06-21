package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.service.ServiceClient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/dinamic")
public class DinamicController {
    private final ServiceClient serviceClients;

    public DinamicController(ServiceClient serviceClients) {
        this.serviceClients = serviceClients;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Проводим удаление рекомендаций по заданному id продукта")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        serviceClients.deleteRule(id);
        return ResponseEntity.status(204).build();

    }
    @PostMapping
    @Operation(summary = "Принимаем POST запрос на добавление продукта, он же на изменение совета")
    public Dinamic addProduct(@RequestBody Dinamic dinamic) {
        return serviceClients.addDinamic(dinamic);
    }

    @GetMapping("/all")
    @Operation(summary = "Отображаем имеющиеся продукты")
    public List<Dinamic> adviceAll() {
        return serviceClients.allAdvice();
    }

    @GetMapping("/dinamic/{user_Id}")
    @Operation(summary = "Вводим id клиента для динамического анализа")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendationsDinamic(@PathVariable UUID user_Id) {
        return ResponseEntity.ok(Optional.of(serviceClients.searchForRecommendationsDinamic(user_Id)));
    }

  }
