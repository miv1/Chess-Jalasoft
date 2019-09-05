package jalasoft.bootcamp.chessgame;

public class Player {
    private String name;
    private Boolean turn;
    private char colorPiece;
    private Boolean winner;

    public Player() {
    }
    
    public Player(String name, boolean turn, char colorPiece) {
        this.name = name;
        this.turn = turn;
        this.colorPiece = colorPiece;
        this.winner=Boolean.FALSE;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isTurn() {
        return turn;
    }
    
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    
    public char getColorPiece() {
        return colorPiece;
    }
    
    public void setColorPiece(char colorPiece) {
        this.colorPiece = colorPiece;
    }
    
    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
