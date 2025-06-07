package sky.group.homeworkgroup.repository;

import org.springframework.jdbc.core.RowMapper;
import sky.group.homeworkgroup.model.InformationClient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<InformationClient> {
    @Override
    public InformationClient mapRow(ResultSet rs, int rowNum) throws SQLException {
        InformationClient informationClient=new InformationClient();
        informationClient.setId(UUID.fromString(rs.getString("id")));
        informationClient.setUser_id(UUID.fromString(rs.getString("user_id")));
        informationClient.setTypeTransaction(rs.getString("type"));
        informationClient.setAmountTransaction(rs.getLong("amount"));
        informationClient.setTypeProduct(rs.getString("type"));
        informationClient.setNameProduct(rs.getString("name"));
        return informationClient;

    }
}
