package sky.group.homeworkgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.service.CacheService;

import java.util.Map;

@RestController
@RequestMapping("/management")
public class CacheController {
    private final CacheService cacheService;
    private final BuildProperties buildProperties;

    @Autowired
    public CacheController(CacheService cacheService, BuildProperties buildProperties) {
        this.cacheService = cacheService;
        this.buildProperties = buildProperties;
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
    public Map<String,String> getServiceInfo() {
        return Map.of(
                "name", buildProperties.getName(),
                "version", buildProperties.getVersion()
        );
    }
}