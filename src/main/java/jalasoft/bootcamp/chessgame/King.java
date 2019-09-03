package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class King extends Piece {

    public King(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }
   
    public King() {
    }
    
    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        ChessSquare newChessSquare;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(currentRow - i) <= 1 && (Math.abs(currentColumn - j) <= 1)) && (i != currentRow || j != currentColumn) && ((spots[i][j] == null) || (spots[i][j].getColor() != color))) {
                        newChessSquare = new ChessSquare();
                        newChessSquare.setRow(i);
                        newChessSquare.setColumn(j);
                        possibleMove.add(newChessSquare);
                }
            }
        }
        return possibleMove;
    }
}
