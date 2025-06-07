package sky.group.homeworkgroup.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sky.group.homeworkgroup.model.InformationClient;

import java.util.List;
import java.util.UUID;

@Repository
public class ProjectRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProjectRepository(@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getRandomTransactionAmount(UUID user) {
        String result = jdbcTemplate.queryForObject(
                "SELECT USERNAME FROM USERS WHERE USERS.ID = ? LIMIT 1",
                String.class, user);
             return result;
    }

    public List<InformationClient> getTransactionAmount(UUID id) {
        return jdbcTemplate.query(
                "SELECT TRANSACTIONS.ID ,TRANSACTIONS.USER_ID, TRANSACTIONS.TYPE,TRANSACTIONS.AMOUNT," +
                        "PRODUCTS.TYPE,PRODUCTS.NAME FROM PRODUCTS INNER JOIN TRANSACTIONS ON " +
                        "TRANSACTIONS.PRODUCT_ID = PRODUCTS.ID WHERE USER_ID =?",
                new UserRowMapper(), id);
      }

}

