package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
public class Rook extends Piece {

    public Rook(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    public Rook() {
    }

    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
       ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        possibleMove.addAll(MovePieces.traceDown(pieceToMove, spots));
        possibleMove.addAll(MovePieces.traceUp(pieceToMove, spots));
        possibleMove.addAll(MovePieces.traceLeft(pieceToMove, spots));
        possibleMove.addAll(MovePieces.traceRight(pieceToMove, spots));
        return possibleMove;
    }
 
    @Override
    public ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece[][] spots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

