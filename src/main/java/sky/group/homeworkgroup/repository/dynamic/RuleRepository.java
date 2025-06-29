package sky.group.homeworkgroup.repository.dynamic;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sky.group.homeworkgroup.model.model_dinamicbase.Rule;
import sky.group.homeworkgroup.model.model_dinamicbase.Statistic;

import java.util.List;

public interface RuleRepository extends JpaRepository<Rule, Long> {

    /**
     * создаем SQL запрос для удаления строки с ячейкой dinamic_id равной id в таблице rule
     */
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM rule WHERE dinamic_id = ?1", nativeQuery = true)
    void deleteLineAllRule(Long id);

    /**
     * создаем JSON SQL запрос для вывода списка объектов Rule с ячейками dinamic_id равными dinamicId
     */
    @Query(value = "SELECT r FROM Rule r JOIN r.dinam d WHERE d.id=?1")
    List<Rule> listRule(Long dinamicId);

    /**
     * Создаем SQL запрос для удаления строки из таблицы rule с ячейкой id равной id
     */
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM rule WHERE id = ?1", nativeQuery = true)
    void deleteLineRule(Long id);

    /**
     * Создаем SQL запрос для добавления строки с нижеуказанными параметрами
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO rule (arguments,negate,query,dinamic_id)VALUES (ARRAY [?1],?2,?3,?4)", nativeQuery = true)
    void saveRule(List<String> arguments, Boolean negate, String query, Long dinamic);
    /**
     * Создаем SQL запрос для записи значения ячейки id в ячейку колонки rule_id по указанному id
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE rule SET rule_id=id,count=0 WHERE dinamic_id=?1", nativeQuery = true)
    void saveRuleCount(Long dinamicId);
    /**
     * Создаем SQL запрос для увеличения значения ячейки count на 1 по строке с dinamic_id равном указанному значению
     */
    @Transactional
    @Modifying
    @Query(value = "UPDATE rule SET count=count+1 WHERE dinamic_id=?1", nativeQuery = true)
    void addCount(Long dinamicId);
    /**
     * Создаем SQL запрос для вывода списка строк по ячейкам принадлежащим классу Statistic
     */
    @Query(value = "SELECT rule_id, count FROM rule", nativeQuery = true)
    List<Statistic> findCount();

}