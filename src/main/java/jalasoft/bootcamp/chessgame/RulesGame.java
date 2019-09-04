/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

/**
 *
 * @author BootCamp LP
 */
public class RulesGame {

    ArrayList<ChessSquare> listMatePositionAux = new ArrayList<ChessSquare>();
    ArrayList<ChessSquare> listMatePosition = new ArrayList<ChessSquare>();

    public Piece[][] putPiece(ChessSquare actualPosition, ChessSquare selectPosition, Piece[][] spots) {
        spots[selectPosition.getRow()][selectPosition.getColumn()] = spots[actualPosition.getRow()][actualPosition.getColumn()];
        spots[actualPosition.getRow()][actualPosition.getColumn()] = null;

        return spots;
    }

    public ArrayList<ChessSquare> listCheckMate(Piece[][] spots, char color) {
        Piece kingPiece = searchKing(spots, color);
        try{
        if (kingPiece != null) {
            listMatePosition = piecePositionMate(kingPiece, spots, color);
        }
        }catch(Exception ex){
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
                        if (matePiece.getTypePiece() == 'P' && matePiece.getColor() != kingPiece.getColor()) {
                            listMatePositionAux = matePawn.searchMate(kingPiece, matePiece, spots);
                        }
//                        if (matePiece.getTypePiece() == 'B' && matePiece.getColor() != kingPiece.getColor() && matePiece != null) {
//                            listMatePositionAux = mateBishop.searchMate(kingPiece, matePiece, spots);
//                        }
//                        if (matePiece.getTypePiece() == 'H' && matePiece.getColor() != kingPiece.getColor() && matePiece != null) {
//                            listMatePositionAux = mateKnight.searchMate(kingPiece, matePiece, spots);
//                        }
                        if(listMatePositionAux.size()>0 && listMatePositionAux!= null){
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
