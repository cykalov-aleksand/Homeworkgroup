package sky.group.homeworkgroup.dinamicrepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;

@Repository
public interface DinamicReposytory extends JpaRepository<Dinamic, Long> {
     @Query(value = "DELETE from dinamicBd.public.dinamic USING rule WHERE dinamic.id=3052",nativeQuery = true)
     Void deleteLine(@Param("idDelete") Long id);

    }
