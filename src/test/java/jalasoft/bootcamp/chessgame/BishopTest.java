package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BishopTest {
   ArrayList<ChessSquare> expectedListResult =new ArrayList<ChessSquare>();
   ArrayList<ChessSquare> currentListResult=new ArrayList<ChessSquare>();
   Board testBoard =new Board();
    public BishopTest() {
    }

    @Before
    public void setUp() throws Exception {
        testBoard.initGame();
    }

@Test
    public void move_noMove_zeroPositions() {
        expectedListResult=null;
        Bishop initialBishop=new Bishop('B', 'B', new ChessSquare(0, 2));
        Pawn diagonalLeftPawn=new Pawn('P', 'B', new ChessSquare(1, 1));
        Pawn downPawn=new Pawn('P', 'B', new ChessSquare(1, 2));
        Pawn diagonalRightPawn=new Pawn('P', 'B', new ChessSquare(1, 3));
        testBoard.spots[0][2]=initialBishop;
        testBoard.spots[1][1]=diagonalLeftPawn;
        testBoard.spots[1][2]=downPawn;
        testBoard.spots[1][3]=diagonalRightPawn;
        currentListResult = initialBishop.move(initialBishop, testBoard.spots);
         for (int i = 0; i < currentListResult.size(); i++) {
             assertEquals(expectedListResult.get(i).getRow(), currentListResult.get(i).getRow());
             assertEquals(expectedListResult.get(i).getColumn(), currentListResult.get(i).getColumn());
        }
    }

    @Test
    public void move_goForwardOrEatRivalMove_listPositions() {
        expectedListResult=new ArrayList<ChessSquare>();
        expectedListResult.add(new ChessSquare(1, 1));
        expectedListResult.add(new ChessSquare(2, 0));
        expectedListResult.add(new ChessSquare(1, 3));
        Bishop attackBishop=new Bishop('B', 'B', new ChessSquare(0, 2));
        Rook rivalRook=new Rook('R', 'W', new ChessSquare(1, 3));
        testBoard.spots[0][2]=attackBishop;
        testBoard.spots[1][3]=rivalRook;
        testBoard.spots[1][1]=null;
        currentListResult = attackBishop.move(attackBishop, testBoard.spots);
         for (int i = 0; i < currentListResult.size(); i++) {
             assertEquals(expectedListResult.get(i).getRow(), currentListResult.get(i).getRow());
             assertEquals(expectedListResult.get(i).getColumn(), currentListResult.get(i).getColumn());
        }
    }
}
