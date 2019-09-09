package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueenTest {

    public QueenTest() {
    }

    Board board = new Board();
    ArrayList<ChessSquare> expResult;

    @Test
    public void test_no_space_move() {
        expResult = new ArrayList<ChessSquare>();
        Queen queenMove = new Queen('B', 'B', new ChessSquare(0, 0));
        board.initGame();
        board.spots[0][0] = queenMove;
        ArrayList<ChessSquare> result = queenMove.move(queenMove, board.spots);
        assertEquals(expResult, result);
    }

    @Test
    public void test_other_pieces_move() {
        expResult = new ArrayList<ChessSquare>();
        board.initGame();
        Queen queenMove = new Queen('B', 'B', new ChessSquare(1, 0));
        board.spots[1][0] = queenMove;
        expResult.add(new ChessSquare(2, 1));
        expResult.add(new ChessSquare(3, 2));
        expResult.add(new ChessSquare(4, 3));
        expResult.add(new ChessSquare(5, 4));
        expResult.add(new ChessSquare(6, 5));
        expResult.add(new ChessSquare(2, 0));
        expResult.add(new ChessSquare(3, 0));
        expResult.add(new ChessSquare(4, 0));
        expResult.add(new ChessSquare(5, 0));
        expResult.add(new ChessSquare(6, 0));
        ArrayList<ChessSquare> result = queenMove.move(queenMove, board.spots);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
        }
    }
}
