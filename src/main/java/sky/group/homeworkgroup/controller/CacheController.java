package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.model.InfoBuild;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.service.CacheService;

import java.util.List;

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
    @GetMapping("/info/change-service")
    @Operation(summary = "Отображаем иформацию по сервису changeInfo")
    public InfoBuild changeServiceInfo() {
        return cacheService.info();
    }

}