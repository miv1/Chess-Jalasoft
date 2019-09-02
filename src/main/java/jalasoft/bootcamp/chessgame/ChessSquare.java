package jalasoft.bootcamp.chessgame;
public class ChessSquare {
    private int row;
    private int column;

    public ChessSquare(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    public ChessSquare() {
    }
    

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
}
