package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.model.InfoBuild;
import sky.group.homeworkgroup.service.CacheService;
import sky.group.homeworkgroup.service.ClientService;
import sky.group.homeworkgroup.service.DinamicClientService;
import sky.group.homeworkgroup.service.logic.Logic;
import sky.group.homeworkgroup.service.logic.LogicDinamic;
import sky.group.homeworkgroup.service.request.DinamicService;
import sky.group.homeworkgroup.service.request.RuleService;


@RestController
@RequestMapping("/management")
public class CacheController {
    private final CacheService cacheService;


    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/clear-caches")
    public ResponseEntity<String> clearAllCaches() {
        try {
            cacheService.clearAllCaches();
            return ResponseEntity.ok("Кеш успешно очищен.");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Произошла ошибка при очистке кеша.");
        }
    }

    @GetMapping("/info")
    @Operation(summary = "Отображаем информацию по сервису")
    public InfoBuild changeServiceInfo() {
        return cacheService.info();
    }
}