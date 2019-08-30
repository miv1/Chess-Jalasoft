package jalasoft.bootcamp.chessgame;

import java.util.List;

public  class Piece {

    
    private String typePiece;
    private String color;
    private ChessSquare currentSquare;
    private List<ChessSquare> ValidMoves;
    
    public Piece(){}
    
    public Piece putPiece(String type, String color, ChessSquare currentSquare) {
        Piece newPiece=new Piece();
        newPiece.typePiece = type;
        newPiece.color = color;
        newPiece.currentSquare = currentSquare;
        return newPiece;
    }
   
    public String getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(String type) {
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