package sky.group.homeworkgroup.dinamicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.time.LocalDateTime;

public interface RuleRepository extends JpaRepository<Rule,Long> {
    @Query(value = "UPDATE rule SET dinamic_id = ?1 WHERE id = ?2",nativeQuery = true)
   void saveRule(Long idDinamic,Long idRule);
}
