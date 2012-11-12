package is.ru.honn.rupin.service;

import is.ru.honn.rupin.data.Board.BoardDataGateway;
import is.ru.honn.rupin.domain.Board;

import java.util.List;

/**
 * @author Jóhann
 * @version 1.0, 12.11.2012
 * @since 12.11.2012, 01:49
 */
public class BoardServiceData implements BoardService {
    BoardDataGateway boardDataGateway;
    @Override
    public int create(Board board) {
        return this.boardDataGateway.createBoard(board);
    }

    @Override
    public List<Board> getBoards(String email) {
        List<Board> boards = boardDataGateway.getBoardsByUser(email);
        return boards;
    }

    @Override
    public void setBoardDataGateway(BoardDataGateway boardDataGateway) {
        this.boardDataGateway = boardDataGateway;
    }
}
