package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
public class Bishop extends Piece {

    public Bishop() {
    }

    public Bishop(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
        ArrayList<ChessSquare> positionMove = new ArrayList<ChessSquare>();
        ChessSquare moves;
        int iniRow = pieceToMove.getCurrentSquare().getRow();
        int iniCol = pieceToMove.getCurrentSquare().getColumn();
        if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'B') {
            for (int finalRow = 0; finalRow < 8; finalRow++) {
                for (int finalCol = 0; finalCol < 8; finalCol++) {
                    if ((Math.abs(iniRow - finalRow)) == Math.abs(iniCol - finalCol)
                            && spots[finalRow][finalCol] == null) {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                    if ((Math.abs(iniRow - finalRow)) == Math.abs(iniCol - finalCol)
                            && spots[finalRow][finalCol] != null && spots[finalRow][finalCol].getColor() == 'W') {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                }
            }
        }
        this.setValidMoves(positionMove);
        return getValidMoves();
    }
}
