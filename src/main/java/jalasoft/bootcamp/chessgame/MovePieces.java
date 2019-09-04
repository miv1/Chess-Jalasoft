package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

class MovePieces {

    static ArrayList<ChessSquare> traceDown(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentRow + 1; i < 8; i++) {
            if (spots[i][currentColumn] == null) {
                possibleMove.add(new ChessSquare(i, currentColumn));
            } else if (spots[i][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(i, currentColumn));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceUp(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentRow - 1; i > -1; i--) {
            if (spots[i][currentColumn] == null) {
                possibleMove.add(new ChessSquare(i, currentColumn));
            } else if (spots[i][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(i, currentColumn));
                break;

            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceLeft(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentColumn - 1; i > -1; i--) {
            if (spots[currentRow][i] == null) {
                possibleMove.add(new ChessSquare(currentRow, i));
            } else if (spots[currentRow][i].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, i));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceRight(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow();
        int currentColumn = pieceToMove.getCurrentSquare().getColumn();
        char color = spots[currentRow][currentColumn].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = currentColumn + 1; i < 8; i++) {
            if (spots[currentRow][i] == null) {
                possibleMove.add(new ChessSquare(currentRow, i));

            } else if (spots[currentRow][i].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, i));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }
    
    
    static ArrayList<ChessSquare> traceDownLeft(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow() + 1;
        int currentColumn = pieceToMove.getCurrentSquare().getColumn() - 1;
        char color = spots[currentRow - 1][currentColumn + 1].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow != 0 || currentColumn != 0) {
            if (spots[currentRow][currentColumn] == null) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                currentRow++;
                currentColumn--;
            } else if (spots[currentRow][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }
    
    static ArrayList<ChessSquare> traceUpRigth(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow() - 1;
        int currentColumn = pieceToMove.getCurrentSquare().getColumn() + 1;
        char color = spots[currentRow + 1][currentColumn - 1].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow != 0 || currentColumn != 0) {
            if (spots[currentRow][currentColumn] == null) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                currentRow--;
                currentColumn++;
            } else if (spots[currentRow][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceUpLeft(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow() - 1;
        int currentColumn = pieceToMove.getCurrentSquare().getColumn() - 1;
        char color = spots[currentRow + 1][currentColumn + 1].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow != 0 || currentColumn != 0) {
            if (spots[currentRow][currentColumn] == null) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                currentRow--;
                currentColumn--;
            } else if (spots[currentRow][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }
    
    
    static ArrayList<ChessSquare> traceDownRight(Piece pieceToMove, Piece[][] spots) {
        int currentRow = pieceToMove.getCurrentSquare().getRow() + 1;
        int currentColumn = pieceToMove.getCurrentSquare().getColumn() + 1;
        char color = spots[currentRow - 1][currentColumn - 1].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow != 8 || currentColumn != 8) {
            if (spots[currentRow][currentColumn] == null) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                currentRow++;
                currentColumn++;
            } else if (spots[currentRow][currentColumn].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }
    
    private boolean verifyColumnPlus(ChessSquare chessSquare) {
        if (chessSquare.getColumn() == 7) {
            return false;
        }
        return true;
    }

    public static boolean verifyColumnMinus(ChessSquare chessSquare) {
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
}
