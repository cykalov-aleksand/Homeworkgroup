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
    private final ClientService clientService;
    private final DinamicClientService dinamicClientService;
    private final DinamicService dinamicService;
    private final RuleService ruleService;
    private final Logic logic;
    private final LogicDinamic logicDinamic;

    public CacheController(CacheService cacheService, ClientService clientService,
                           DinamicClientService dinamicClientService, DinamicService dinamicService,
                           RuleService ruleService, Logic logic, LogicDinamic logicDinamic) {
        this.cacheService = cacheService;
        this.clientService = clientService;
        this.dinamicClientService = dinamicClientService;
        this.dinamicService = dinamicService;
        this.ruleService = ruleService;
        this.logic = logic;
        this.logicDinamic = logicDinamic;
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

    @GetMapping("/info/changeService")
    @Operation(summary = "Отображаем информацию по сервису ChangeService")
    public InfoBuild changeServiceInfo() {
        return cacheService.info();
    }

    @GetMapping("/info/clientService")
    @Operation(summary = "Отображаем информацию по сервису ClientService")
    public InfoBuild clientServiceInfo() {
        return clientService.info();
    }

    @GetMapping("/info/dinamicClientService")
    @Operation(summary = "Отображаем информацию по сервису DinamicClientService")
    public InfoBuild dinamicClientServiceInfo() {
        return dinamicClientService.info();
    }

    @GetMapping("/info/request/dinamicService")
    @Operation(summary = "Отображаем информацию по сервису DinamicService")
    public InfoBuild dinamicServiceInfo() {
        return dinamicService.info();
    }

    @GetMapping("/info/request/ruleService")
    @Operation(summary = "Отображаем информацию по сервису RuleService")
    public InfoBuild RuleServiceInfo() {
        return ruleService.info();
    }

    @GetMapping("/info/logic/logic")
    @Operation(summary = "Отображаем информацию по сервису Logic")
    public InfoBuild logicInfo() {
        return logic.info();
    }

    @GetMapping("/info/logic/logicDinamic")
    @Operation(summary = "Отображаем информацию по сервису LogicDinamic")
    public InfoBuild LogicDinamicInfo() {
        return logicDinamic.info();
    }
}