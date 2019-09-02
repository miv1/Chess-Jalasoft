package jalasoft.bootcamp.chessgame;

class VerifyMove {

    private char typePiece;
    private ChessSquare chessSquare;

    public char getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(char typePiece) {
        this.typePiece = typePiece;
    }

    public ChessSquare getChessSquare() {
        return chessSquare;
    }

    public void setChessSquare(ChessSquare chessSquare) {
        this.chessSquare = chessSquare;
    }

    public void MovePiece(Piece piece) {
        switch (piece.getType()) {
            case 'K':
                piece.getCurrentSquare().; // code block
                break;
            case 'Q':
                // code block
                break;
            case 'B':
                // code block
                break;
            default:
            // code block
        }

        for (int i = 0; i < 8; i++) {
        }
    }

    private boolean verifyColumnPlus(ChessSquare chessSquare) {
        if (chessSquare.getColumn() == 7) {
            return false;
        }
        return true;
    }
    
    private boolean verifyColumnMinus(ChessSquare chessSquare) {
        if (chessSquare.getColumn() == 0) {
            return false;
        }
        return true;
    }
    
    private boolean verifyRowMinus(ChessSquare chessSquare) {
        if (chessSquare.getRow() == 0) {
            return false;
        }
        return true;
    }
    
     private boolean verifyRowPlus(ChessSquare chessSquare) {
        if (chessSquare.getRow() == 7) {
            return false;
        }
        return true;
    }
     Board board = new Board();
      private boolean verifyOtherPiece(ChessSquare chessSquareTarjet, Piece piece, ) {
        if(chessSquareTarjet.getRow(). '')
          
          if (piece.getColor() chessSquareTarjet.getRow() == 7) {
            return false;
        }
        return true;
    }
    

}
