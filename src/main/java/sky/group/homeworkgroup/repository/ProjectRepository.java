package sky.group.homeworkgroup.repository;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "transactions_cache", key = "#id")
    public List<InformationClient> getListTransactions(UUID id) {
        return jdbcTemplate.query(
                "SELECT TRANSACTIONS.ID ,TRANSACTIONS.USER_ID, TRANSACTIONS.TYPE,TRANSACTIONS.AMOUNT," +
                        "PRODUCTS.TYPE,PRODUCTS.NAME FROM PRODUCTS INNER JOIN TRANSACTIONS ON " +
                        "TRANSACTIONS.PRODUCT_ID = PRODUCTS.ID WHERE USER_ID =?",
                new UserRowMapper(), id);
    }
}