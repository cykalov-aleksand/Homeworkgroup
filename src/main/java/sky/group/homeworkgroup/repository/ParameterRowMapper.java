package sky.group.homeworkgroup.repository;

import org.springframework.jdbc.core.RowMapper;
import sky.group.homeworkgroup.model.modeljbd.InformationClient;
import sky.group.homeworkgroup.model.modeljbd.UserParameters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ParameterRowMapper implements RowMapper<UserParameters> {
    @Override
    public UserParameters mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserParameters userParameters = new UserParameters();
        userParameters.setId(UUID.fromString(rs.getString("id")));
        userParameters.setLastName(rs.getString("last_name"));
        userParameters.setFirstName(rs.getString("first_name"));
        return userParameters;
    }
}
