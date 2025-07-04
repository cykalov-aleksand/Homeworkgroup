package sky.group.homeworkgroup;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@OpenAPIDefinition
@SpringBootApplication
public class HomeworkgroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkgroupApplication.class, args);
	}

}
