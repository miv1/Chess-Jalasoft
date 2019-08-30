package jalasoft.bootcamp.chessgame;

import java.util.List;

public abstract class Piece {
    private String type;
    private String color;
    private ChessSquare currentSquare;
    private List<ChessSquare> ValidMoves;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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