package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.Board.BoardDataGateway;
import is.ru.honn.rupin.domain.Board;

import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 01:49
 */
public interface BoardService {
    public int create(Board board);
    public List<Board> getBoards(String email);
    public void setBoardDataGateway(BoardDataGateway boardDataGateway);
}