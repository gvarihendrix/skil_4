package is.ru.honn.rupin.data.Board;

import is.ru.honn.rupin.domain.Board;

import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 01:20
 */
public interface BoardDataGateway {
    public int createBoard(Board board);
    public List<Board> getBoardsByUser(String email);
}
