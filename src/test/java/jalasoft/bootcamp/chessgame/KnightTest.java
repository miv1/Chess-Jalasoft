package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class KnightTest {

    ArrayList<ChessSquare> expectedListResult = new ArrayList<ChessSquare>();
    ArrayList<ChessSquare> currentListResult = new ArrayList<ChessSquare>();
    Board testBoard = new Board();

    public KnightTest() {
    }

    @Test
    public void move_goForwardOrEatRivalMove_listPositions() {
        expectedListResult = new ArrayList<ChessSquare>();
        expectedListResult.add(new ChessSquare(2, 0));
        expectedListResult.add(new ChessSquare(2, 4));
        expectedListResult.add(new ChessSquare(4, 0));
        expectedListResult.add(new ChessSquare(4, 4));
        expectedListResult.add(new ChessSquare(5, 1));
        expectedListResult.add(new ChessSquare(5, 3));
        testBoard.initGame();
        Knight attackKnight = new Knight('H', 'B', new ChessSquare(3, 2));
        Rook rivalRook = new Rook('R', 'W', new ChessSquare(2, 0));
        testBoard.spots[3][2] = attackKnight;
        testBoard.spots[2][0] = rivalRook;
        currentListResult = attackKnight.move(attackKnight, testBoard.spots);
        for (int i = 0; i < currentListResult.size(); i++) {
            assertEquals(expectedListResult.get(i).getRow(), currentListResult.get(i).getRow());
            assertEquals(expectedListResult.get(i).getColumn(), currentListResult.get(i).getColumn());
        }
    }
}
