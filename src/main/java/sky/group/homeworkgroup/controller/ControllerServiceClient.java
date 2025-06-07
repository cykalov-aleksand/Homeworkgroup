package sky.group.homeworkgroup.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.group.homeworkgroup.model.InformationClient;
import sky.group.homeworkgroup.service.ServiceClient;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/recommendation")
public class ControllerServiceClient {
    private final ServiceClient serviceClients;

    public ControllerServiceClient(ServiceClient serviceClients) {
        this.serviceClients = serviceClients;
    }
    @GetMapping("{user_Id}")
    @Operation(summary = "Получаем факультет студента по указанному id")
    public ResponseEntity<String> getFaculty(@PathVariable UUID user_Id) {

        return ResponseEntity.ok(serviceClients.user(user_Id));
    }
    @GetMapping("/information/{user_Id}")
    @Operation(summary = "Получаем информацию о клиенте по указанному id")
    public ResponseEntity<Collection<InformationClient>> get(@PathVariable UUID user_Id) {

        return ResponseEntity.ok(serviceClients.print(user_Id));
    }
}
