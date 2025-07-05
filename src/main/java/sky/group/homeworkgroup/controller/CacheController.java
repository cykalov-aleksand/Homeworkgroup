package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.model.InfoBuild;
import sky.group.homeworkgroup.service.CacheService;


@RestController
@RequestMapping("/management")
@Tag(name = "Контроллер Cache ", description = "Предназначен для очистки кеша и вывода информации по сервису")
public class CacheController {
    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/clear-caches")
    @Operation(summary = "Производим полную очистку кеша")
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