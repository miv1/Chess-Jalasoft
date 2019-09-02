package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
<<<<<<< HEAD
    private char type;
    private String color;
    private ChessSquare currentSquare;
    private List<ChessSquare> ValidMoves;

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
=======

    
    private char typePiece;
    private String color;
    private ChessSquare currentSquare;
    private List<ChessSquare> ValidMoves;
    
   
//    public Piece putPiece(char type, String color, ChessSquare currentSquare) {
//        Piece newPiece=new Piece();
//        newPiece.typePiece = type;
//        newPiece.color = color;
//        newPiece.currentSquare = currentSquare;
//        return newPiece;
//    }
   
    public char getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(char type) {
        this.typePiece = type;
>>>>>>> dev
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ChessSquare getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(ChessSquare currentSquare) {
        this.currentSquare = currentSquare;
    }

    public List<ChessSquare> getValidMoves() {
        return ValidMoves;
    }

    public void setValidMoves(List<ChessSquare> ValidMoves) {
        this.ValidMoves = ValidMoves;
    }
     public ArrayList<LegalMoves> capturePiece(ChessSquare posMove, Piece spots[][]) {
        //this.ValidMoves = spots[posMove.getRow()][posMove.getColumn()];
        //ArrayList<LegalMoves> positionMove = new ArrayList<LegalMoves>();
        if (pieceToMove.getTypePiece() == 'P') {
            positionMove=move(pieceToMove, this.spots);
        }
        return positionMove;
    }
    public abstract ArrayList<LegalMoves> move(Piece pieceToMove, Piece spots[][]);
    //public abstract ArrayList<LegalMoves> capturePiece(ChessSquare posMove,Board spots[][]);
}