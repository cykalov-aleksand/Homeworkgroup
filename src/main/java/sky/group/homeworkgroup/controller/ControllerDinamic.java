package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;
import sky.group.homeworkgroup.service2.DinamicService;

@RestController
@RequestMapping("/")
public class ControllerDinamic {
    private final DinamicService dinamicService;

    public ControllerDinamic(DinamicService dinamicService) {
        this.dinamicService = dinamicService;
        }

    @PostMapping
   @Operation(summary = "Добавляем студента")
      public Dinamic createStudent(@RequestBody Dinamic dinamic) {
        return dinamicService.addDinamic(dinamic);
 }
}
