package sky.group.homeworkgroup.dinamicrepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sky.group.homeworkgroup.model_dinamicbase.Dinamic;

@Repository
public interface DinamicReposytory extends JpaRepository<Dinamic, Long> {

    }
