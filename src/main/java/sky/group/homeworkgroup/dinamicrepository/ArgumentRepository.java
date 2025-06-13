package sky.group.homeworkgroup.dinamicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import sky.group.homeworkgroup.model_dinamicbase.Argument;

public interface ArgumentRepository extends JpaRepository<Argument,Long> {
}
