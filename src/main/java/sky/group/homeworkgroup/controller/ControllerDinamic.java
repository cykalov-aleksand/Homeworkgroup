package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.serviceDinamic.DinamicService;

import java.util.List;


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
        return ResponseEntity.ok().build();
    }
    @GetMapping
    @Operation(summary = "Отображаем имеющиеся советы")
    public List<Dinamic> AdviceAll() {
        return dinamicService.allAdvice();
            }
}


