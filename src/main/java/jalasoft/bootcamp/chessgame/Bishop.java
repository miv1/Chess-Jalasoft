package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class Bishop extends Piece {

    ArrayList<ChessSquare> positionMove = new ArrayList<ChessSquare>();
    ChessSquare moves;

    public Bishop() {
    }

    public Bishop(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }

    @Override public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
       ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        possibleMove.addAll(MovePieces.traceDownLeft(pieceToMove, spots));
        possibleMove.addAll(MovePieces.traceDownRight(pieceToMove, spots));
        possibleMove.addAll(MovePieces.traceUpLeft(pieceToMove, spots));
        possibleMove.addAll(MovePieces.traceUpRigth(pieceToMove, spots));
        return possibleMove;
    }
    
    public ArrayList<ChessSquare> movew(Piece pieceToMove, Piece[][] spots) {

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
        } else if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'W') {
            for (int finalRow = 0; finalRow < 8; finalRow++) {
                for (int finalCol = 0; finalCol < 8; finalCol++) {
                    if ((Math.abs(iniRow - finalRow)) == Math.abs(iniCol - finalCol)
                            && spots[finalRow][finalCol] == null) {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                    if ((Math.abs(iniRow - finalRow)) == Math.abs(iniCol - finalCol)
                            && spots[finalRow][finalCol] != null && spots[finalRow][finalCol].getColor() == 'B') {
                        moves = new ChessSquare(finalRow, finalCol);
                        positionMove.add(moves);
                    }
                }
            }
        }
        this.setValidMoves(positionMove);
        return getValidMoves();
    }

    @Override
    public ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece[][] spots) {
        for (int searchRow = 0; searchRow < 8; searchRow++) {
            for (int searchCol = 0; searchCol < 8; searchCol++) {
                if ((Math.abs(matePiece.getCurrentSquare().getRow() - searchRow)) == Math.abs(matePiece.getCurrentSquare().getColumn() - searchCol)
                        && searchRow == kingPiece.getCurrentSquare().getRow()
                        && searchCol == kingPiece.getCurrentSquare().getColumn()) {
                    moves = new ChessSquare(searchRow, searchCol);
                    positionMove.add(moves);
                }
            }
        }
        return positionMove;
    }
}
