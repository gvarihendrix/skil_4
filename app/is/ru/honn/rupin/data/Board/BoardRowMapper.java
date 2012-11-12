package is.ru.honn.rupin.data.Board;

import is.ru.honn.rupin.domain.Board;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 01:21
 */
public class BoardRowMapper implements ParameterizedRowMapper<Board> {
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new Board(rs.getInt("id"),
                rs.getString("creator"),
                rs.getDate("created"),
                rs.getString("name"),
                rs.getString("category"));
    }
}