package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class RulesGame {

    ArrayList<ChessSquare> listMatePositionAux = new ArrayList<ChessSquare>();
    ArrayList<ChessSquare> listMatePosition = new ArrayList<ChessSquare>();
    Board board = new Board();

    boolean verifyMate(Piece piece, Piece[][] spots) {
        ArrayList<ChessSquare> possibleMove = piece.move(piece, spots);
        for (ChessSquare move : possibleMove) {
            if (spots[move.getRow()][move.getColumn()] != null && spots[move.getRow()][move.getColumn()].getColor() != piece.getColor() && spots[move.getRow()][move.getColumn()].getTypePiece() == 'K') {
                return true;
            }
        }
        return false;
    }

//    public ArrayList<ChessSquare> fillMove(ArrayList<ChessSquare> possibleMove, ChessSquare currentPosition, ChessSquare){
//        possibleMove.
//    ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
//    return possibleMove;
//    }
    public boolean verifyCheck() {
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        ArrayList<Piece> listPieces = new ArrayList<Piece>();
        // char color = 'B';
        ChessSquare positionKing = board.getKing(listPieces.get(0).getColor());
        for (ChessSquare move : possibleMove) {
            if (move.equals(positionKing)) {
                return true;
            }
        }
        return false;
    }

    boolean movePiece(ChessSquare inputPosition, ArrayList<ChessSquare> possibleMove, ChessSquare currentPosition, Piece[][] spots) {
        for (ChessSquare chessSquare : possibleMove) {
            if (inputPosition.getRow() == chessSquare.getRow() && inputPosition.getColumn() == chessSquare.getColumn()) {
                spots[inputPosition.getRow()][inputPosition.getColumn()] = spots[currentPosition.getRow()][currentPosition.getColumn()];
                spots[inputPosition.getRow()][inputPosition.getColumn()].setCurrentSquare(inputPosition);
                spots[currentPosition.getRow()][currentPosition.getColumn()] = null;
                return true;
            }
        }
        return false;
    }

    private Piece searchKing(Piece[][] spots, char color) {

        for (int searchRow = 0; searchRow < 8; searchRow++) {
            for (int searchCol = 0; searchCol < 8; searchCol++) {
                if (spots[searchRow][searchCol] != null && spots[searchRow][searchCol].getColor() == color
                        && spots[searchRow][searchCol].getTypePiece() == 'K') {
                    return spots[searchRow][searchCol];
                }
            }
        }
        return null;
    }
}
