/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author BootCamp LP
 */
public class Game {

    private Board board = new Board();
   
    public static void main(String[] args) {
        int actualRow, actualColumn;
        int selectedRow, selectedColumn;
        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        RulesGame rules = new RulesGame();
        ArrayList<ChessSquare> listPositionMove = new ArrayList<ChessSquare>();
        
        
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
        
       for(ChessSquare move: listPositionMove){
           System.out.println("Row : " + move.getRow() +" Column : "+ move.getColumn());
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
