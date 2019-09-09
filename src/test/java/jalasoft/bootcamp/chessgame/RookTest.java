package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {

    public RookTest() {
    }

    Board board = new Board();
    ArrayList<ChessSquare> expResult;

    @Test
    public void test_no_space_move() {
        expResult = new ArrayList<ChessSquare>();
        Rook rookMove = new Rook('B', 'B', new ChessSquare(0, 0));
        board.initGame();
        board.spots[0][0] = rookMove;
        ArrayList<ChessSquare> result = rookMove.move(rookMove, board.spots);
        assertEquals(expResult, result);
    }

    @Test
    public void test_other_pieces_move() {
        expResult = new ArrayList<ChessSquare>();
        board.initGame();
        Rook rookMove = new Rook('B', 'B', new ChessSquare(1, 0));
        board.spots[1][0] = rookMove;
        expResult.add(new ChessSquare(2, 0));
        expResult.add(new ChessSquare(3, 0));
        expResult.add(new ChessSquare(4, 0));
        expResult.add(new ChessSquare(5, 0));
        expResult.add(new ChessSquare(6, 0));
        ArrayList<ChessSquare> result = rookMove.move(rookMove, board.spots);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
        }
    }

    @Test
    public void test_rival_move() {
        expResult = new ArrayList<ChessSquare>();
        board.initGame();
        Rook rookMove = new Rook('B', 'B', new ChessSquare(5, 5));
        board.spots[5][5] = rookMove;
        ArrayList<ChessSquare> result = rookMove.move(rookMove, board.spots);
        expResult.add(new ChessSquare(6, 5));
        expResult.add(new ChessSquare(4, 5));
        expResult.add(new ChessSquare(3, 5));
        expResult.add(new ChessSquare(2, 5));
        expResult.add(new ChessSquare(5, 4));
        expResult.add(new ChessSquare(5, 3));
        expResult.add(new ChessSquare(5, 2));
        expResult.add(new ChessSquare(5, 1));
        expResult.add(new ChessSquare(5, 0));
        expResult.add(new ChessSquare(5, 6));
        expResult.add(new ChessSquare(5, 7));
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expResult.get(i).getColumn(), result.get(i).getColumn());
            assertEquals(expResult.get(i).getRow(), result.get(i).getRow());
        }
    }
}
