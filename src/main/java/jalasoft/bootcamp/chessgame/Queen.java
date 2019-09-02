package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class Queen extends Piece{
     public Queen(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    @Override
    public ArrayList<LegalMoves> move(Piece pieceToMove, Piece[][] spots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
