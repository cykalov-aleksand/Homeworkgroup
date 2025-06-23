package sky.group.homeworkgroup.repository.dynamic;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sky.group.homeworkgroup.model.model_dinamicbase.Dinamic;

import java.util.List;

@Repository
public interface DinamicReposytory extends JpaRepository<Dinamic, Long> {

    /**
     * Создаем SQL запрос для удаления строки из таблицы dinamic с указанным id
     */
    @Transactional
    @Modifying
    @Query(value = "DELETE from dinamic WHERE id= ?1", nativeQuery = true)
    void deleteLine(Long id);

    /**
     * Создаем SQL запрос для вывода списка объектов Dinamic из таблицы dinamic
     */
    @Query(value = "SELECT * FROM dinamic", nativeQuery = true)
    List<Dinamic> find();

    /**
     * Создаем SQL запрос для вывода списка элементов id из таблицы dinamic
     */
    @Query(value = "SELECT id FROM dinamic", nativeQuery = true)
    List<Long> idDinamic();

    /**
     * Создаем SQL запрос для поиска объекта Dinamic с указанным id
     */
    @Query(value = "SELECT * FROM dinamic WHERE id=?1", nativeQuery = true)
    Dinamic findId(Long id);

}
