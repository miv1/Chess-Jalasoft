/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BootCamp LP
 */
public class Board {

    Piece spots[][] = new Piece[8][8];
    private ArrayList<ChessSquare> ValidMoves;

    public void initGame() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    //Piece pieceSpot=new Piece("P","W",new ChessSquare(i,j));
                    spots[i][j] = new Pawn('P', 'B', new ChessSquare(i, j));

                } else if (i == 6) {
                    spots[i][j] = new Pawn('P', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    spots[i][j] = new Rook('R', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    spots[i][j] = new Rook('R', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    spots[i][j] = new Knight('H', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    spots[i][j] = new Knight('H', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    spots[i][j] = new Bishop('B', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    spots[i][j] = new Bishop('B', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 3)) {
                    spots[i][j] = new Queen('Q', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 4)) {
                    spots[i][j] = new Queen('Q', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 4)) {
                    spots[i][j] = new King('K', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 3)) {
                    spots[i][j] = new King('K', 'W', new ChessSquare(i, j));
                } else {
                    Piece pieceSpot = null;
                    spots[i][j] = pieceSpot;
                }
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.spots[i][j] == null) {
                    System.out.print(" " + "|");
                } else {
                    System.out.print(this.spots[i][j].getTypePiece() + "|");
                }
            }
            System.out.println("");
        }
    }

    public void showSelectedPiece(ChessSquare actualPosition) {
        Piece pieceCapture = this.spots[actualPosition.getRow()][actualPosition.getColumn()];
        System.out.println("Your choose to move is a : " + this.spots[actualPosition.getRow()][actualPosition.getColumn()].getTypePiece() + " the color is :"
                + this.spots[actualPosition.getRow()][actualPosition.getColumn()].getColor() + " the position is : " + actualPosition.getRow() + " , " + actualPosition.getColumn());
    }

    public ArrayList<ChessSquare> capturePiece(ChessSquare actualPosition) {
        Piece pieceCapture = this.spots[actualPosition.getRow()][actualPosition.getColumn()];
        Pawn movePawn = new Pawn();
        Bishop moveBishop = new Bishop();
        Knight moveKnight = new Knight();
        if (pieceCapture.getTypePiece() == 'P') {
            ValidMoves = movePawn.move(pieceCapture, this.spots);
        } else if (pieceCapture.getTypePiece() == 'B') {
            ValidMoves = moveBishop.move(pieceCapture, this.spots);
        } else if (pieceCapture.getTypePiece() == 'H') {
            ValidMoves = moveKnight.move(pieceCapture, this.spots);
        }
        return ValidMoves;
    }
   
   
            
    

}
