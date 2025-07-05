package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.model.model_dinamicbase.DynamicRecord;
import sky.group.homeworkgroup.service.request.DinamicService;

import java.util.List;


@RestController
@RequestMapping("/dinamic")
@Tag(name = "Контроллер Dinamic ", description = "Предназначен для работы с предлагаемыми продуктами (вывод информации, удаление, добавление)")
public class DinamicController {
    private final DinamicService dinamicService;

    public DinamicController(DinamicService dinamicService) {
        this.dinamicService = dinamicService;
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Проводим удаление рекомендаций по заданному id продукта")
    public ResponseEntity<Void> deleteRule(@PathVariable @Parameter(description = "удаляемого продукта", required = true) Long id) {
        dinamicService.deleteRule(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping
    @Operation(summary = "Принимаем POST запрос на добавление продукта, он же на изменение совета")
    public Dinamic addProduct(@RequestBody DynamicRecord dinamic) {
        return dinamicService.addDinamic(new Dinamic(dinamic.productId(), dinamic.productName(), dinamic.text(), dinamic.rule()));
    }

    @GetMapping("/all")
    @Operation(summary = "Отображаем имеющиеся продукты")
    public List<Dinamic> adviceAll() {
        return dinamicService.allAdvice();
    }
}
