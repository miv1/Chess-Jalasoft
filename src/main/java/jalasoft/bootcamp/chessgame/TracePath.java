package jalasoft.bootcamp.chessgame;
import java.util.List;
public class TracePath {

    private ChessSquare squareIni;
    private ChessSquare squareEnd;
    private List<ChessSquare> trace;

    boolean hasValidTrace(int row, int column) {
        //for(int i = 0; i< trace.size();i++)
        for (ChessSquare chessSquare : trace) {
            if (chessSquare.getRow() == row && chessSquare.getColumn() == column) {
                return true;
            }
        }
        return false;
    }

    public ChessSquare getSquareIni() {
        return squareIni;
    }

    public void setSquareIni(ChessSquare squareIni) {
        this.squareIni = squareIni;
    }

    public ChessSquare getSquareEnd() {
        return squareEnd;
    }

    public void setSquareEnd(ChessSquare squareEnd) {
        this.squareEnd = squareEnd;
    }

    public List<ChessSquare> getTrace() {
        return trace;
    }

    public void setTrace(List<ChessSquare> trace) {
        this.trace = trace;
    }
}
