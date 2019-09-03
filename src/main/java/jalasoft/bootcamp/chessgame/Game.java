package jalasoft.bootcamp.chessgame;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        
        int actualRow, actualColumn;
        int selectedRow, selectedColumn;
        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        RulesGame rules = new RulesGame();
        ArrayList<ChessSquare> listPositionMove; 
        boardGame.initGame();
        boardGame.showBoard();
        
        System.out.println("Your turn... Choose a piece... ");
        System.out.println("Enter the row... ");
        actualRow=sn.nextInt();
        System.out.println("Enter the column... ");
        actualColumn=sn.nextInt();
        
        boardGame.showSelectedPiece(new ChessSquare(actualRow, actualColumn));
        listPositionMove=boardGame.capturePiece(new ChessSquare(actualRow, actualColumn));
        
        System.out.println("Your possibles movements are... ");
        
        
       for(ChessSquare mover: listPositionMove){
           System.out.println("Row: " + mover.getRow() + " Column: " + mover.getColumn());
       }
       System.out.println("Choose your movement... ");
       System.out.println("Enter the row... ");
       selectedRow=sn.nextInt();
       System.out.println("Enter the column... ");
       selectedColumn=sn.nextInt();
       
       boardGame.spots=rules.putPiece(new ChessSquare(actualRow, actualColumn), new ChessSquare(selectedRow, selectedColumn),boardGame.spots);
       boardGame.showBoard();
    }
}
