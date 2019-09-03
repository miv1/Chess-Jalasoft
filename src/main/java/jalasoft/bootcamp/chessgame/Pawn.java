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
public class Pawn extends Piece {

    public Pawn() {
    }

    public Pawn(char type, char color, ChessSquare currentSquare) {

        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }
        
    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
        ArrayList<ChessSquare> positionMove = new ArrayList<ChessSquare>();
        ChessSquare moves;

        if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'B') {

            if (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
            if (spots[pieceToMove.getCurrentSquare().getRow() + 2][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 2, pieceToMove.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
            if ((spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() - 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() - 1].getColor() == 'W')) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() - 1);
                positionMove.add(moves);
            }
            if ((spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'W')) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() + 1);
                positionMove.add(moves);
            }
        } else if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'W') {

            if (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
            if (spots[pieceToMove.getCurrentSquare().getRow() - 2][pieceToMove.getCurrentSquare().getColumn()] == null) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 2, pieceToMove.getCurrentSquare().getColumn());
                positionMove.add(moves);

            }
            if ((spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() - 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() - 1].getColor() == 'B')) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn() - 1);
                positionMove.add(moves);
            }
            if ((spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() + 1] != null)
                    && (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'B')) {
                moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn() + 1);
                positionMove.add(moves);
            }
        }
        this.setValidMoves(positionMove);
        return getValidMoves();
    }

}
