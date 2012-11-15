package is.ru.honn.rupin.data.User;

import is.ru.honn.rupin.domain.Follow;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jóhann
 * @version 1.0, 15.11.2012
 * @since 15.11.2012, 00:53
 */
public class FollowRowMapper implements ParameterizedRowMapper<Follow> {
    @Override
    public Follow mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Follow(resultSet.getString("useremail"), resultSet.getString("follows"));
    }
}
