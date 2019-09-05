package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;

 abstract class Piece {

    private char typePiece;
    private char color;
    private ChessSquare currentSquare;
    private ArrayList<ChessSquare> validMoves;

    public char getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(char type) {
        this.typePiece = type;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public ChessSquare getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(ChessSquare currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void setValidMoves(ArrayList<ChessSquare> ValidMoves) {
        this.validMoves = ValidMoves;
    }   

    public ArrayList<ChessSquare> getValidMoves() {
        return validMoves;
    }

    public void setValidMoves(List<ChessSquare> ValidMoves) {
        this.validMoves = (ArrayList<ChessSquare>) ValidMoves;
    }

    abstract ArrayList<ChessSquare> move(Piece pieceToMove, Piece spots[][]);
    abstract ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece spots[][]);

}
