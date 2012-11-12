package is.ru.honn.rupin.data.User;

import is.ru.honn.rupin.domain.User;
import is.ruframework.data.RuData;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jóhann
 * @version 1.0, 11.11.2012
 * @since 11.11.2012, 01:30
 */
public class UserData extends RuData implements UserDataGateway {
    @Override
    public User getUserByID(int id) {
        JdbcTemplate simpleJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            // Query for single User
            return (User)simpleJdbcTemplate.queryForObject(
                    "select * from ru_Users where id=?",
                    new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e){ // If User not exists!
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        JdbcTemplate simpleJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            // Query for single User
            return (User)simpleJdbcTemplate.queryForObject(
                    "select * from ru_Users where email=?",
                    new UserRowMapper(), email);
        } catch (EmptyResultDataAccessException e){ // If User not exists!
            return null;
        }
    }

    @Override
    public User authenticate(String email, String password) {
        JdbcTemplate simpleJdbcTemplate = new JdbcTemplate(getDataSource());
        try {
            // Query for single User
            return (User)simpleJdbcTemplate.queryForObject(
                    "SELECT * FROM ru_Users where email=? and password=?",
                    new UserRowMapper(), email, password);
        } catch (EmptyResultDataAccessException e){ // If User not exists!
            return null;
        }
    }

    @Override
    public int addUser(User user) {
        SimpleJdbcInsert insertContent =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_Users")
                        .usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("email", user.getEmail());
        parameters.put("fullname", user.getFullname());
        parameters.put("password", user.getPassword());
        return insertContent.executeAndReturnKey(parameters).intValue();
    }
}
