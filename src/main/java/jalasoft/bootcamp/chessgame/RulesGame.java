package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class RulesGame {

    ArrayList<ChessSquare> listMatePositionAux = new ArrayList<ChessSquare>();
    ArrayList<ChessSquare> listMatePosition = new ArrayList<ChessSquare>();

    boolean verifyMate(Piece piece, Piece[][] spots) {
        ArrayList<ChessSquare> possibleMove = piece.move(piece, spots);
        for (ChessSquare move : possibleMove) {
            if (spots[move.getRow()][move.getColumn()] != null && spots[move.getRow()][move.getColumn()].getColor() != piece.getColor() && spots[move.getRow()][move.getColumn()].getTypePiece() == 'K') {
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

    public Piece[][] putPiece(ChessSquare actualPosition, ChessSquare selectPosition, Piece[][] spots, Player gamePlayer) {
        if (spots[selectPosition.getRow()][selectPosition.getColumn()] != null) {
            if (spots[selectPosition.getRow()][selectPosition.getColumn()].getTypePiece() == 'K'
                    && spots[actualPosition.getRow()][actualPosition.getColumn()].getColor() != spots[selectPosition.getRow()][selectPosition.getColumn()].getColor()) {
                spots[selectPosition.getRow()][selectPosition.getColumn()] = spots[actualPosition.getRow()][actualPosition.getColumn()];
                spots[selectPosition.getRow()][selectPosition.getColumn()].setCurrentSquare(actualPosition);
                spots[actualPosition.getRow()][actualPosition.getColumn()] = null;
                gamePlayer.setWinner(Boolean.TRUE);
            } else {

                spots[selectPosition.getRow()][selectPosition.getColumn()] = spots[actualPosition.getRow()][actualPosition.getColumn()];
                spots[actualPosition.getRow()][actualPosition.getColumn()] = null;
                gamePlayer.setWinner(Boolean.FALSE);
            }
        } else {
            spots[selectPosition.getRow()][selectPosition.getColumn()] = spots[actualPosition.getRow()][actualPosition.getColumn()];
            spots[selectPosition.getRow()][selectPosition.getColumn()].setCurrentSquare(selectPosition);
            spots[actualPosition.getRow()][actualPosition.getColumn()] = null;
            gamePlayer.setWinner(Boolean.FALSE);
        }
        return spots;
    }

    public ArrayList<ChessSquare> listCheckMate(Piece[][] spots, char color) {
        Piece kingPiece = searchKing(spots, color);
        try {
            if (kingPiece != null) {
                listMatePosition = piecePositionMate(kingPiece, spots, color);
            }
        } catch (Exception ex) {
            System.out.println("ERROR listCheckMate" + ex.getMessage().toString());
        }

        return listMatePosition;
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

    private ArrayList<ChessSquare> piecePositionMate(Piece kingPiece, Piece[][] spots, char color) {
        Pawn matePawn = new Pawn();
        Bishop mateBishop = new Bishop();
        Knight mateKnight = new Knight();
        Piece matePiece;
        try {
            for (int searchRow = 0; searchRow < 8; searchRow++) {
                for (int searchCol = 0; searchCol < 8; searchCol++) {
                    matePiece = spots[searchRow][searchCol];
                    //System.out.println("PIEZA... " + matePiece.getTypePiece() + " " + matePiece.getColor() + " " + searchRow + "," + searchCol);
                    if (matePiece != null) {
                        listMatePositionAux.clear();
//                        if (matePiece.getTypePiece() == 'P' && matePiece.getColor() != kingPiece.getColor()) {
//                            listMatePositionAux = matePawn.searchMate(kingPiece, matePiece, spots);
//                        }
                        if (matePiece.getTypePiece() == 'B' && matePiece.getColor() != kingPiece.getColor()) {
                            listMatePositionAux = mateBishop.searchMate(kingPiece, matePiece, spots);
                        }
//                        if (matePiece.getTypePiece() == 'H' && matePiece.getColor() != kingPiece.getColor() && matePiece != null) {
//                            listMatePositionAux = mateKnight.searchMate(kingPiece, matePiece, spots);
//                        }
//                        if (matePiece.getTypePiece() == 'R' && matePiece.getColor() != kingPiece.getColor() && matePiece != null) {
//                            listMatePositionAux = mateKnight.searchMate(kingPiece, matePiece, spots);
//                        }
//                        if (matePiece.getTypePiece() == 'Q' && matePiece.getColor() != kingPiece.getColor() && matePiece != null) {
//                            listMatePositionAux = mateKnight.searchMate(kingPiece, matePiece, spots);
//                        }
                        if (listMatePositionAux.size() > 0 && listMatePositionAux != null) {
                            listMatePosition.addAll(listMatePositionAux);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("ERROR piecePositionMate..." + ex.toString());
        }
        return listMatePosition;
    }
}
