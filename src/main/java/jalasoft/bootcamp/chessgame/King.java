package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(char type, char color, ChessSquare currentSquare) {
        super.setTypePiece(type);
        super.setColor(color);
        super.setCurrentSquare(currentSquare);
    }
    Board board = new Board();

    public King() {
    }

    static ArrayList<String> validMovess(ChessSquare chessSquare, Board board) {
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        
        ArrayList<String> possibleMoveS = new ArrayList<String>();
        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                int roww = Math.abs(chessSquare.getRow() - i);
                int coll = Math.abs(chessSquare.getRow() - j);
                if (Math.abs(chessSquare.getRow() - i) <= 1 && (Math.abs(chessSquare.getRow() - j) <= 1)) {
                    chessSquare.setRow(i);
                    chessSquare.setColumn(j);
                    possibleMoveS.add("row " + roww + " col " + coll + " i " + i + " j " + j);
                }
            }
        }
          return possibleMoveS;
        //return possibleMove;
    }

    //ArrayList<ChessSquare> validMove(ChessSquare chessSquare, Board board) {
    Piece validMove(ChessSquare chessSquare, Board board) {

        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        ChessSquare newChessSquare;
        
        Piece aas = board.spots[chessSquare.getRow()][chessSquare.getColumn()];
       
                
        char color = board.spots[chessSquare.getRow()][chessSquare.getColumn()].getColor();
        if (color == 'W') {
            color = 'B';
        } else {
            color = 'W';
        }

        if (board.spots[chessSquare.getRow() + 1][chessSquare.getColumn()] == null || board.spots[chessSquare.getRow() + 1][chessSquare.getColumn()].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow() + 1);
            newChessSquare.setColumn(chessSquare.getColumn());
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow() - 1][chessSquare.getColumn()] == null || board.spots[chessSquare.getRow() - 1][chessSquare.getColumn()].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow() - 1);
            newChessSquare.setColumn(chessSquare.getColumn());
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow()][chessSquare.getColumn() + 1] == null || board.spots[chessSquare.getRow()][chessSquare.getColumn() + 1].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow());
            newChessSquare.setColumn(chessSquare.getColumn() + 1);
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow()][chessSquare.getColumn() - 1] == null || board.spots[chessSquare.getRow()][chessSquare.getColumn() - 1].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow());
            newChessSquare.setColumn(chessSquare.getColumn() - 1);
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow() + 1][chessSquare.getColumn() + 1] == null || board.spots[chessSquare.getRow() + 1][chessSquare.getColumn() + 1].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow() + 1);
            newChessSquare.setColumn(chessSquare.getColumn() + 1);
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow() - 1][chessSquare.getColumn() - 1] == null || board.spots[chessSquare.getRow() - 1][chessSquare.getColumn() - 1].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow() - 1);
            newChessSquare.setColumn(chessSquare.getColumn() - 1);
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow() + 1][chessSquare.getColumn() - 1] == null || board.spots[chessSquare.getRow() + 1][chessSquare.getColumn() - 1].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow() + 1);
            newChessSquare.setColumn(chessSquare.getColumn() - 1);
            possibleMove.add(chessSquare);
        }

        if (board.spots[chessSquare.getRow() - 1][chessSquare.getColumn() + 1] == null || board.spots[chessSquare.getRow() - 1][chessSquare.getColumn() + 1].getColor() == color) {
            newChessSquare = new ChessSquare();
            newChessSquare.setRow(chessSquare.getRow() - 1);
            newChessSquare.setColumn(chessSquare.getColumn() + 1);
            possibleMove.add(chessSquare);
        }

         return aas;
        //return possibleMove;
    }
    @Override
    public ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
