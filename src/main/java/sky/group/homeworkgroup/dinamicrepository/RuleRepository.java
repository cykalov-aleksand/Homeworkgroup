package sky.group.homeworkgroup.dinamicrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

public interface RuleRepository extends JpaRepository<Rule,Long> {
    @Query(value = "UPDATE rule SET dinamic_id = ?1 WHERE id = ?2",nativeQuery = true)
   void saveRule(Long idDinamic,Long idRule);

    @Query(value = "DELETE FROM rule WHERE dinamic_id = ?1",nativeQuery = true)
    void deleteLine(Long id);
}
