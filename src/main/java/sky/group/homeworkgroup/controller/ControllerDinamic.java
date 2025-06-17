package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sky.group.homeworkgroup.model.OutputData;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.serviceDinamic.DinamicService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/rule")
public class ControllerDinamic {
    private final DinamicService dinamicService;

    public ControllerDinamic(DinamicService dinamicService) {
        this.dinamicService = dinamicService;
    }

    @PostMapping
    @Operation(summary = "Принимаем POST запрос и заносим его в две таблицы")
    public Dinamic createStudent(@RequestBody Dinamic dinamic) {
        return dinamicService.addDinamic(dinamic);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Проводим удаление рекомендаций по заданному id таблицы")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        dinamicService.deleteRule(id);
        return ResponseEntity.status(204).build();

    }

    @GetMapping
    @Operation(summary = "Отображаем имеющиеся советы")
    public List<Dinamic> AdviceAll() {
        return dinamicService.allAdvice();
    }
   @GetMapping("/recomendation/{user_Id}")
   @Operation(summary = "Вводим id клиента для динамического анализа")
    public ResponseEntity<Optional<List<OutputData>>> getRecommendations(@PathVariable UUID user_Id) {
        return ResponseEntity.ok(Optional.of(dinamicService.searchForRecommendations(user_Id)));
    }
}


