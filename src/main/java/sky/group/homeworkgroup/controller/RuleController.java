package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sky.group.homeworkgroup.model.model_dinamicbase.Rule;
import sky.group.homeworkgroup.model.model_dinamicbase.Statistic;
import sky.group.homeworkgroup.service.request.RuleService;

import java.util.List;


@RestController
@RequestMapping("/rule")
public class RuleController {
    private final RuleService ruleService;

    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Проводим удаление рекомендаций с id совета из продукта по заданному id продукта")
    public ResponseEntity<String> deleteRule(@RequestParam("ID product") Long idProduct, @RequestParam("ID rule") Long idRule) {
        String result = ruleService.deleteRule(idProduct, idRule);
        if (result.equals("Строка удалена")) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/allRule")
    @Operation(summary = "Отображаем имеющиеся советы по продукту с заданным id")
    public List<Rule> adviceAll(@RequestParam("ID product") Long idProduct) {
        return ruleService.allAdvice(idProduct);
    }
    @GetMapping("/stats")
    @Operation(summary = "Отображаем статистику использования динамических правил")
    public List<Statistic> listStaticCount() {
        return ruleService.listStatic();
    }
}


