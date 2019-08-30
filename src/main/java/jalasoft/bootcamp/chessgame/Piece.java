package jalasoft.bootcamp.chessgame;

import java.util.List;

public  class Piece {

    
    private char typePiece;
    private String color;
    private ChessSquare currentSquare;
    private List<ChessSquare> ValidMoves;
    
    public Piece(){}
    
    public Piece putPiece(char type, String color, ChessSquare currentSquare) {
        Piece newPiece=new Piece();
        newPiece.typePiece = type;
        newPiece.color = color;
        newPiece.currentSquare = currentSquare;
        return newPiece;
    }
   
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

    public List<ChessSquare> getValidMoves() {
        return ValidMoves;
    }

    public void setValidMoves(List<ChessSquare> ValidMoves) {
        this.ValidMoves = ValidMoves;
    }
}