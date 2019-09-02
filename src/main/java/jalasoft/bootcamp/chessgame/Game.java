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

    public static void main(String[] args) {
        int row, col;

        King king = new King();
        ChessSquare chessSquare = new ChessSquare(0, 4);

        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        ArrayList<ChessSquare> listPositionMove = new ArrayList<ChessSquare>();

        boardGame.initGame();
        boardGame.showBoard();

        System.out.println("Your turn... Choose a piece");
        System.out.println("Enter the row... ");
        row = sn.nextInt();
        System.out.println("Enter the column... ");
        col = sn.nextInt();

        listPositionMove = king.validMovess(chessSquare, boardGame);
        //listPositionMove = king.validMove(chessSquare, board);
        //System.out.println(king.validMove(chessSquare, boardGame));

        System.out.println("Your possibles movements are...");

        for (ChessSquare move : listPositionMove) {
            System.out.println(move.getRow() + move.getColumn());
        }

    }

}
