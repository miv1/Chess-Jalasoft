package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
   ArrayList<ChessSquare> expectedListResult =new ArrayList<ChessSquare>();
   ArrayList<ChessSquare> currentListResult=new ArrayList<ChessSquare>();
   Board testBoard =new Board();
   
    public PawnTest() {
    }

    @Before
    public void setUp() {
        testBoard.initGame();
    }

    @Test
    public void move_initialMove_twoPositions() {
        expectedListResult.add(new ChessSquare(2, 0));
        expectedListResult.add(new ChessSquare(3, 0));
        Pawn initialPawn=new Pawn('P', 'B', new ChessSquare(1, 0));
        testBoard.spots[1][0]=initialPawn;
        currentListResult = initialPawn.move(initialPawn, testBoard.spots);
         for (int i = 0; i < currentListResult.size(); i++) {
             assertEquals(expectedListResult.get(i).getRow(), currentListResult.get(i).getRow());
             assertEquals(expectedListResult.get(i).getColumn(), currentListResult.get(i).getColumn());
        }
    }

    @Test
    public void move_goForwardOrEatRivalMove_threePositions() {
        expectedListResult=new ArrayList<ChessSquare>();
        expectedListResult.add(new ChessSquare(3, 3));
        expectedListResult.add(new ChessSquare(3, 2));
        expectedListResult.add(new ChessSquare(3, 4));
        Pawn attackPawn=new Pawn('P', 'B', new ChessSquare(2, 3));
        Rook rivalRook=new Rook('R', 'W', new ChessSquare(3, 2));
        Bishop rivalBishop=new Bishop('B', 'W', new ChessSquare(3, 4));
        testBoard.spots[2][3]=attackPawn;
        testBoard.spots[3][2]=rivalRook;
        testBoard.spots[3][4]=rivalBishop;
        testBoard.spots[3][3]=null;
        testBoard.spots[4][3]=null;
        currentListResult = attackPawn.move(attackPawn, testBoard.spots);
         for (int i = 0; i < currentListResult.size(); i++) {
             assertEquals(expectedListResult.get(i).getRow(), currentListResult.get(i).getRow());
             assertEquals(expectedListResult.get(i).getColumn(), currentListResult.get(i).getColumn());
        }
    }
}
