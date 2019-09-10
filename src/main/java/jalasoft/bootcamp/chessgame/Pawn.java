package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class Pawn extends Piece {

    
    ChessSquare moves;
    ArrayList<ChessSquare> positionMove = new ArrayList<ChessSquare>();

    public Pawn(char typePiece, char color, ChessSquare currentSquare) {
        super(typePiece, color, currentSquare);
    }

   

    public Pawn(){}
    
    

    @Override
    ArrayList<ChessSquare> move(Piece pieceToMove, Piece[][] spots) {
        Validation movesPawn = new Validation();
        if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'B') {
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn()))) {
                if (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn()] == null) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn());
                    positionMove.add(moves);
                }
            }
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 2, pieceToMove.getCurrentSquare().getColumn()))
                    && spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn()] == null
                    && pieceToMove.getCurrentSquare().getRow() == 1) {
                if (spots[pieceToMove.getCurrentSquare().getRow() + 2][pieceToMove.getCurrentSquare().getColumn()] == null) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 2, pieceToMove.getCurrentSquare().getColumn());
                    positionMove.add(moves);
                }
            }
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() - 1))) {
                if ((spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() - 1] != null)
                        && (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() - 1].getColor() == 'W')) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() - 1);
                    positionMove.add(moves);
                }
            }
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() - 1))) {
                if ((spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1] != null)
                        && (spots[pieceToMove.getCurrentSquare().getRow() + 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'W')) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() + 1, pieceToMove.getCurrentSquare().getColumn() + 1);
                    positionMove.add(moves);
                }
            }
        } else if (spots[pieceToMove.getCurrentSquare().getRow()][pieceToMove.getCurrentSquare().getColumn()].getColor() == 'W') {
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn()))) {
                if (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn()] == null) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn());
                    positionMove.add(moves);
                }
            }
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 2, pieceToMove.getCurrentSquare().getColumn()))
                    && spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn()] == null
                    && pieceToMove.getCurrentSquare().getRow() == 6) {
                if (spots[pieceToMove.getCurrentSquare().getRow() - 2][pieceToMove.getCurrentSquare().getColumn()] == null) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 2, pieceToMove.getCurrentSquare().getColumn());
                    positionMove.add(moves);
                }
            }
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn() - 1))) {
                if ((spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() - 1] != null)
                        && (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() - 1].getColor() == 'B')) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn() - 1);
                    positionMove.add(moves);
                }
            }
            if (movesPawn.validateMovesPawn(new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn() + 1))) {
                if ((spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() + 1] != null)
                        && (spots[pieceToMove.getCurrentSquare().getRow() - 1][pieceToMove.getCurrentSquare().getColumn() + 1].getColor() == 'B')) {
                    moves = new ChessSquare(pieceToMove.getCurrentSquare().getRow() - 1, pieceToMove.getCurrentSquare().getColumn() + 1);
                    positionMove.add(moves);
                }
            }
        }
        this.setValidMoves(positionMove);
        return getValidMoves();
    }

    @Override
    ArrayList<ChessSquare> searchMate(Piece kingPiece, Piece matePiece, Piece spots[][]) {
        if (spots[matePiece.getCurrentSquare().getRow()][matePiece.getCurrentSquare().getColumn()].getColor() == 'B') {
            if ((matePiece.getCurrentSquare().getRow() + 1 == kingPiece.getCurrentSquare().getRow())
                    && (matePiece.getCurrentSquare().getColumn() + 1 == kingPiece.getCurrentSquare().getColumn())) {
                moves = new ChessSquare(matePiece.getCurrentSquare().getRow(), matePiece.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
            if ((matePiece.getCurrentSquare().getRow() - 1 == kingPiece.getCurrentSquare().getRow())
                    && (matePiece.getCurrentSquare().getColumn() - 1 == kingPiece.getCurrentSquare().getColumn())) {
                moves = new ChessSquare(matePiece.getCurrentSquare().getRow(), matePiece.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
        } else if (spots[matePiece.getCurrentSquare().getRow()][matePiece.getCurrentSquare().getColumn()].getColor() == 'W') {
            if ((matePiece.getCurrentSquare().getRow() - 1 == kingPiece.getCurrentSquare().getRow())
                    && (matePiece.getCurrentSquare().getColumn() - 1 == kingPiece.getCurrentSquare().getColumn())) {
                moves = new ChessSquare(matePiece.getCurrentSquare().getRow(), matePiece.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
            if ((matePiece.getCurrentSquare().getRow() - 1 == kingPiece.getCurrentSquare().getRow())
                    && (matePiece.getCurrentSquare().getColumn() + 1 == kingPiece.getCurrentSquare().getColumn())) {
                moves = new ChessSquare(matePiece.getCurrentSquare().getRow(), matePiece.getCurrentSquare().getColumn());
                positionMove.add(moves);
            }
        }
        return positionMove;
    }
}
