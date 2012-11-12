package is.ru.honn.rupin.data.Board;

import is.ru.honn.rupin.domain.Board;
import is.ruframework.data.RuData;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 01:29
 */
public class BoardData extends RuData implements BoardDataGateway{
    @Override
    public int createBoard(Board board) {
        SimpleJdbcInsert insertContent =
                new SimpleJdbcInsert(getDataSource())
                        .withTableName("ru_Boards")
                        .usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(4);
        parameters.put("creator", board.getCreator());
        parameters.put("created", board.getCreated());
        parameters.put("name", board.getName());
        parameters.put("category", board.getCategory());
        return insertContent.executeAndReturnKey(parameters).intValue();
    }

    @Override
    public List<Board> getBoardsByUser(String email) {
        JdbcTemplate queryBoard = new JdbcTemplate(getDataSource());
        // Query for list of boards by email
        List<Board> boards = queryBoard.query("SELECT * FROM ru_Boards where creator=?",
                new BoardRowMapper(), email);

        // Return the boards
        return boards;
    }
}
