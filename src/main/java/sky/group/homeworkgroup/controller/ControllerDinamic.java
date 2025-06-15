package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model_dinamicbase.Rule;
import sky.group.homeworkgroup.serviceDinamic.DinamicService;

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
    @Operation(summary = "Проводим удаление студента по заданному id")
    public ResponseEntity<Void> deleteRule(@PathVariable Long id) {
        dinamicService.deleteRule(id);
        return ResponseEntity.ok().build();

    }
}


