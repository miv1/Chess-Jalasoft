package jalasoft.bootcamp.chessgame;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        King king = new King();
        ChessSquare chessSquare = new ChessSquare(0, 4);
        
        int actualRow, actualColumn;
        int selectedRow, selectedColumn;
        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        RulesGame rules = new RulesGame();
        ArrayList<ChessSquare> listPositionMove = new ArrayList<ChessSquare>();        
        
        ArrayList<String> listPositionMovew = new ArrayList<String>();
        
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
        
        listPositionMovew = King.validMovess(chessSquare, boardGame);
        
       for(String mover: listPositionMovew){
           System.out.println(mover);
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
