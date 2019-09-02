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
public class Pawn extends Piece{

     public Pawn(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }
     
//    public ArrayList<LegalMoves> capturePiece(ChessSquare posMove) {
//        Pawn paww = new Pawn();
//        Piece pieceToMove = this.spots[posMove.getRow()][posMove.getColumn()];
//        ArrayList<LegalMoves> positionMove = new ArrayList<LegalMoves>();
//        if (pieceToMove.getTypePiece() == 'P') {
//            positionMove = move(pieceToMove, this.spots);
//        }
//        return positionMove;
//    }
    
    @Override
    public ArrayList<LegalMoves> move(Piece pieceToMove, Piece[][] spots) {
         ArrayList<LegalMoves> positionMove = new ArrayList<LegalMoves>();
        LegalMoves moves;

        if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'B') {
            if (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn(), "G");
                positionMove.add(moves);
            } else if (spots[pieceToMove.getCurrentSquare().getRow() + 2][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() + 2, pieceToMove.getCurrentSquare().getColumn() + 1, "G");
                positionMove.add(moves);
            } else if ((spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() - 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'W')) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() - 1, "E");
                positionMove.add(moves);
            } else if ((spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'W')) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() + 1, "E");
                positionMove.add(moves);
            }
        } else if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'W') {
            if (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn(), "G");
                positionMove.add(moves);
            } else if (spots[pieceToMove.getCurrentSquare().getRow() - 2][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() - 2, pieceToMove.getCurrentSquare().getColumn(), "G");
                positionMove.add(moves);
            } else if ((spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() - 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() - 1].getColor() == 'B')) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() + 1, "E");
                positionMove.add(moves);
            } else if ((spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() + 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'B')) {
                moves = new LegalMoves(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() + 1, "E");
                positionMove.add(moves);
            }
        }
        return positionMove;
    }

   

 
}
