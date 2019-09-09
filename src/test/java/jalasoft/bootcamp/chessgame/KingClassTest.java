package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KingClassTest {
    Board board = new Board();
    ArrayList<ChessSquare> expResult;

    @Test
    public void test_no_space_move() {
        expResult = new ArrayList<ChessSquare>();
        King kingNoMove = new King('B', 'B', new ChessSquare(0, 0));
        board.spots[0][0] = kingNoMove;
        ArrayList<ChessSquare> result = kingNoMove.move(kingNoMove, board.spots);
        assertEquals(expResult, result);
    }

    @Test
    public void test_other_pieces_move() {
        expResult = new ArrayList<ChessSquare>();
        board.initGame();
        King kingNoMove = new King('B', 'B', new ChessSquare(1, 0));
        board.spots[1][0] = kingNoMove;
        expResult.add(new ChessSquare(2, 0));
        expResult.add(new ChessSquare(2, 1));
        ArrayList<ChessSquare> result = kingNoMove.move(kingNoMove, board.spots);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
        }
    }

    @Test
    public void test_rival_move() {
        expResult = new ArrayList<ChessSquare>();
        board.initGame();
        King kingNoMove = new King('B', 'B', new ChessSquare(5, 7));
        board.spots[5][7] = kingNoMove;
        ArrayList<ChessSquare> result = kingNoMove.move(kingNoMove, board.spots);
        expResult.add(new ChessSquare(4, 6));
        expResult.add(new ChessSquare(4, 7));
        expResult.add(new ChessSquare(5, 6));
        expResult.add(new ChessSquare(6, 6));
        expResult.add(new ChessSquare(6, 7));
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
        }
    }
}
