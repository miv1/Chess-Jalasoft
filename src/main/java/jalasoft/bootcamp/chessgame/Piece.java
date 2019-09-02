package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    
    private char typePiece;
    private String color;
    private ChessSquare currentSquare;
    private ArrayList<ChessSquare> ValidMoves;
    
    public char getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(char type) {
        this.typePiece = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ChessSquare getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(ChessSquare currentSquare) {
        this.currentSquare = currentSquare;
    }

    public ArrayList<ChessSquare> getValidMoves() {
        return ValidMoves;
    }

    public void setValidMoves(List<ChessSquare> ValidMoves) {
        this.ValidMoves = (ArrayList<ChessSquare>) ValidMoves;
    }
     
    public abstract ArrayList<ChessSquare> move(Piece pieceToMove, Piece spots[][]);
    
}