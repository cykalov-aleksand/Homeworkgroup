package sky.group.homeworkgroup.dinamicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

public interface RuleRepository extends JpaRepository<Rule,Long> {
}
