package sky.group.homeworkgroup.dinamicrepository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;

import java.util.List;

@Repository
public interface DinamicReposytory extends JpaRepository<Dinamic, Long> {
   @Transactional
    @Modifying
    @Query(value = "DELETE from dinamic WHERE id= ?1", nativeQuery = true)
    void deleteLine(Long id);

    @Query(value = "SELECT * FROM dinamic", nativeQuery = true)
    List<Dinamic> find();
    @Query(value="SELECT id FROM dinamic",nativeQuery = true)
 List<Long> idDinamic();

}
