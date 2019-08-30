/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

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
        
        boardGame.initGame();
        boardGame.showBoard();
        
        System.out.println("Your turn... Choose a piece");
        System.out.println("Enter the row... ");
        row=sn.nextInt();
        System.out.println("Enter the column... ");
        col=sn.nextInt();
        
        boardGame.capturePiece(new ChessSquare(row, col));
    }
           
}
