package sky.group.homeworkgroup.dinamicrepository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sky.group.homeworkgroup.model_dinamicbase.Rule;

import java.util.List;

public interface RuleRepository extends JpaRepository<Rule,Long> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE rule SET dinamic_id = ?1 WHERE id = ?2",nativeQuery = true)
   void saveRule(Long idDinamic,Long idRule);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM rule WHERE dinamic_id = ?1",nativeQuery = true)
    void deleteLine(Long id);
    @Query(value="SELECT r FROM Rule r JOIN r.dinam d WHERE d.id=?1")
          List<Rule>listRule(Long dinamicId);
   }
