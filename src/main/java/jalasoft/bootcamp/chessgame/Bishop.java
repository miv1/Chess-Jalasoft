package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class Bishop extends Piece {

    ArrayList<ChessSquare> positionMove = new ArrayList<ChessSquare>();
    ChessSquare moves;

    public Bishop() {
    }

    public Bishop(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    @Override public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
       ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        possibleMove.addAll(Validation.traceDownLeft(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceDownRight(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceUpLeft(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceUpRigth(pieceToMove.getCurrentSquare(), spots));
        return possibleMove;
    }
    
    @Override
    public ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece[][] spots) {
        for (int searchRow = 0; searchRow < 8; searchRow++) {
            for (int searchCol = 0; searchCol < 8; searchCol++) {
                if ((Math.abs(matePiece.getCurrentSquare().getRow() - searchRow)) == Math.abs(matePiece.getCurrentSquare().getColumn() - searchCol)
                        && searchRow == kingPiece.getCurrentSquare().getRow()
                        && searchCol == kingPiece.getCurrentSquare().getColumn()) {
                    moves = new ChessSquare(searchRow, searchCol);
                    positionMove.add(moves);
                }
            }
        }
        return positionMove;
    }
}
