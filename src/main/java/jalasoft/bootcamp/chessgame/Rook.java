/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

/**
 *
 * @author BootCamp LP
 */
public class Rook extends Piece {

    public Rook(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    public Rook() {
    }

    //@Override
    public ArrayList<ChessSquare> moves(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ChessSquare newChessSquare;
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((currentRow == i || currentColumn == j) && ((spots[i][j] == null) || (spots[i][j].getColor() != color))) {
                    newChessSquare = new ChessSquare();
                    newChessSquare.setRow(i);
                    newChessSquare.setColumn(j);
                    possibleMove.add(newChessSquare);
                }
            }
        }
        return possibleMove;
    }

    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
       ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        possibleMove.addAll(traceDown(pieceToMove, spots));
        possibleMove.addAll(traceUp(pieceToMove, spots));
        possibleMove.addAll(traceLeft(pieceToMove, spots));
        possibleMove.addAll(traceRight(pieceToMove, spots));
        return possibleMove;
    }
    
    public ArrayList<ChessSquare> traceDown(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentRow + 1; i < 8; i++) {
            if (spots[i][currentColumn] == null) {
                possibleMove.add(new ChessSquare(i, currentColumn));
            } else if (spots[i][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(i, currentColumn));
                break;
                        
            } else {
                break;
            }
        }
        return possibleMove;
    }
    
 public ArrayList<ChessSquare> traceUp(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentRow - 1; i > -1; i--) {
            if (spots[i][currentColumn] == null) {
                possibleMove.add(new ChessSquare(i, currentColumn));
            } else if (spots[i][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(i, currentColumn));
                break;
                        
            } else {
                break;
            }
        }
        return possibleMove;
    }
    
    public ArrayList<ChessSquare> traceLeft(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentColumn - 1; i > -1; i--) {
            if (spots[currentRow][i] == null) {
                possibleMove.add(new ChessSquare(currentRow, i));
            } else if (spots[currentRow][i].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, i));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    public ArrayList<ChessSquare> traceRight(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentColumn + 1; i < 8; i++) {
            if (spots[currentRow][i] == null) {
                possibleMove.add(new ChessSquare(currentRow, i));

            } else if (spots[currentRow][i].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, i));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }
}

