package is.ru.honn.rupin.data;

import is.ru.honn.rupin.domain.User;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:34
 */
public class UserRowMapper implements ParameterizedRowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new User(rs.getInt("id"),
                rs.getString("email"),
                rs.getString("fullname"),
                rs.getString("password"));
    }
}
