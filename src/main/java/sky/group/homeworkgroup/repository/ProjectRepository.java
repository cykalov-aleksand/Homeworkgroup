package sky.group.homeworkgroup.repository;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sky.group.homeworkgroup.model.modeljbd.InformationClient;
import sky.group.homeworkgroup.model.modeljbd.UserParameters;

import java.util.List;
import java.util.UUID;

@Repository
public class ProjectRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProjectRepository(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Создаем JSON SQL запрос для вывода списка объектов InformationClient с ячейками iser_id равными id
     */
    @Cacheable(value = "transactions_cache", key = "#id", unless = "#result == null")
    public List<InformationClient> getListTransactions(UUID id) {
        return jdbcTemplate.query(
                "SELECT TRANSACTIONS.ID ,TRANSACTIONS.USER_ID, TRANSACTIONS.TYPE,TRANSACTIONS.AMOUNT," +
                        "PRODUCTS.TYPE,PRODUCTS.NAME FROM PRODUCTS INNER JOIN TRANSACTIONS ON " +
                        "TRANSACTIONS.PRODUCT_ID = PRODUCTS.ID WHERE USER_ID =?",
                new UserRowMapper(), id);
    }

    /**
     * Создаем SQL запрос для подсчета количество строк содержащими определенное значение ячейки username
     */
    public int countUserName(String userName) {
        Integer result = jdbcTemplate.queryForObject(
                "SELECT COUNT(USERNAME) FROM USERS u WHERE u.username = ?", Integer.class, userName);
        return result != null ? result : 0;
    }

    /**
     * Создаём SQL запрос для вывода строки содержащей определенное значение в ячейке username
     */
    @Cacheable(value = "userParams", key = "#userName", unless = "#result==null")
    public UserParameters findUserParameters(String userName) {
        return jdbcTemplate.queryForObject(
                "SELECT ID,FIRST_NAME,LAST_NAME FROM USERS u WHERE u.USERNAME =?",
                new ParameterRowMapper(), userName);
    }
}


