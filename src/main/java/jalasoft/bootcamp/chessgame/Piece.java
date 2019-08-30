package jalasoft.bootcamp.chessgame;
public abstract class Piece {
    private String type;
    private String color;
    private char rowCurrent;
    private byte columnCurrent;

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

    public char getRowCurrent() {
        return rowCurrent;
    }

    public void setRowCurrent(char rowCurrent) {
        this.rowCurrent = rowCurrent;
    }

    public byte getColumnCurrent() {
        return columnCurrent;
    }

    public void setColumnCurrent(byte columnCurrent) {
        this.columnCurrent = columnCurrent;
    }
    
   public boolean move()
   {
       return true;
   }
    
}
