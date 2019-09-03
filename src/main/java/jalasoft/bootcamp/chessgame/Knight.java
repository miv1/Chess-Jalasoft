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
public class Knight extends Piece {

    ArrayList<ChessSquare> positionMove = new ArrayList<ChessSquare>();
    ChessSquare moves;

    public Knight() {
    }

    public Knight(char type, char color, ChessSquare currentSquare) {

        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {

        int iniRow = pieceToMove.getCurrentSquare().getRow();
        int iniCol = pieceToMove.getCurrentSquare().getColumn();
        if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'B') {
            for (int finalRow = 0; finalRow < 8; finalRow++) {
                for (int finalCol = 0; finalCol < 8; finalCol++) {
                    if (((iniRow - finalRow) * (iniRow - finalRow)) + ((iniCol - finalCol) * (iniCol - finalCol)) == 5
                            && spots[finalRow][finalCol] == null) {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                    if (((iniRow - finalRow) * (iniRow - finalRow)) + ((iniCol - finalCol) * (iniCol - finalCol)) == 5
                            && spots[finalRow][finalCol] != null && spots[finalRow][finalCol].getColor() == 'W') {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                }
            }
        } else if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'W') {
            for (int finalRow = 0; finalRow < 8; finalRow++) {
                for (int finalCol = 0; finalCol < 8; finalCol++) {
                    if (((iniRow - finalRow) * (iniRow - finalRow)) + ((iniCol - finalCol) * (iniCol - finalCol)) == 5
                            && spots[finalRow][finalCol] == null) {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                    if (((iniRow - finalRow) * (iniRow - finalRow)) + ((iniCol - finalCol) * (iniCol - finalCol)) == 5
                            && spots[finalRow][finalCol] != null && spots[finalRow][finalCol].getColor() == 'B') {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                }
            }
        }

        this.setValidMoves(positionMove);

        return getValidMoves();

    }

    @Override
    public ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece[][] spots) {
        for (int searchRow = 0; searchRow < 8; searchRow++) {
            for (int searchCol = 0; searchCol < 8; searchCol++) {
                if (((matePiece.getCurrentSquare().getRow() - searchRow) * (matePiece.getCurrentSquare().getRow() - searchRow)) + ((matePiece.getCurrentSquare().getColumn() - searchCol) * (matePiece.getCurrentSquare().getColumn() - searchCol)) == 5
                        && searchRow == kingPiece.getCurrentSquare().getRow()
                        && searchCol == kingPiece.getCurrentSquare().getColumn()
                        ) {
                    moves = new ChessSquare(searchRow, searchCol);
                    positionMove.add(moves);
                }
            }
        }
        return null;
    }

}
