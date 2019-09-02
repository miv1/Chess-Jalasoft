/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author BootCamp LP
 */
public class Game {

    private Board board = new Board();
   
    public static void main(String[] args) {
        int row, col;
        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        ArrayList<LegalMoves> listPositionMove = new ArrayList<LegalMoves>();
        
        
        boardGame.initGame();
        boardGame.showBoard();
        
        System.out.println("Your turn... Choose a piece");
        System.out.println("Enter the row... ");
        row=sn.nextInt();
        System.out.println("Enter the column... ");
        col=sn.nextInt();
        
        //listPositionMove=boardGame.capturePiece(new ChessSquare(row, col));
        
        System.out.println("Your possibles movements are...");
        
       for(LegalMoves move: listPositionMove){
           System.out.println(move.row + move.col + move.typeMove);
       }
        
    }
           
}
