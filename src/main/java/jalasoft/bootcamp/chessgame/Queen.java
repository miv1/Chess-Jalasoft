package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    public Queen() {
    }

    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        possibleMove.addAll(Validation.traceDownLeft(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceDownRight(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceUpRigth(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceUpLeft(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceDown(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceLeft(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceRight(pieceToMove.getCurrentSquare(), spots));
        possibleMove.addAll(Validation.traceUp(pieceToMove.getCurrentSquare(), spots));
        return possibleMove;
    }

    @Override
    public ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece[][] spots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
