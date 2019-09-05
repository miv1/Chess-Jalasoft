package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

class Validation {

    static ArrayList<ChessSquare> traceDown(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = pieceToMove.getRow() + 1; i < 8; i++) {
            if (spots[i][pieceToMove.getColumn()] == null) {
                possibleMove.add(new ChessSquare(i, pieceToMove.getColumn()));
            } else if (spots[i][pieceToMove.getColumn()].getColor() != color) {
                possibleMove.add(new ChessSquare(i, pieceToMove.getColumn()));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceUp(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = pieceToMove.getRow() - 1; i > -1; i--) {
            if (spots[i][pieceToMove.getColumn()] == null) {
                possibleMove.add(new ChessSquare(i, pieceToMove.getColumn()));
            } else if (spots[i][pieceToMove.getColumn()].getColor() != color) {
                possibleMove.add(new ChessSquare(i, pieceToMove.getColumn()));
                break;

            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceLeft(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = pieceToMove.getColumn() - 1; i > -1; i--) {
            if (spots[pieceToMove.getRow()][i] == null) {
                possibleMove.add(new ChessSquare(pieceToMove.getRow(), i));
            } else if (spots[pieceToMove.getRow()][i].getColor() != color) {
                possibleMove.add(new ChessSquare(pieceToMove.getRow(), i));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceRight(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        for (int i = pieceToMove.getColumn() + 1; i < 8; i++) {
            if (spots[pieceToMove.getRow()][i] == null) {
                possibleMove.add(new ChessSquare(pieceToMove.getRow(), i));
            } else if (spots[pieceToMove.getRow()][i].getColor() != color) {
                possibleMove.add(new ChessSquare(pieceToMove.getRow(), i));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceDownRight(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        int currentRow = pieceToMove.getRow() + 1;
        int currentColumn = pieceToMove.getColumn() + 1;
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow != 8 && currentColumn != 8) {
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

    static ArrayList<ChessSquare> traceDownLeft(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        int currentRow = pieceToMove.getRow() + 1;
        int currentColumn = pieceToMove.getColumn() - 1;
        while (currentRow < 8 && currentColumn > -1) {
            if (spots[currentRow][pieceToMove.getColumn()] == null) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                currentRow++;
                currentColumn--;
            } else if (spots[currentRow][pieceToMove.getColumn()].getColor() != color) {
                possibleMove.add(new ChessSquare(currentRow, currentColumn));
                break;
            } else {
                break;
            }
        }
        return possibleMove;
    }

    static ArrayList<ChessSquare> traceUpRigth(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();

        int currentRow = pieceToMove.getRow() - 1;
        int currentColumn = pieceToMove.getColumn() + 1;

        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow > -1 && currentColumn < 8) {
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

    static ArrayList<ChessSquare> traceUpLeft(ChessSquare pieceToMove, Piece[][] spots) {
        char color = spots[pieceToMove.getRow()][pieceToMove.getColumn()].getColor();
        int currentRow = pieceToMove.getRow() - 1;
        int currentColumn = pieceToMove.getColumn() - 1;
        ArrayList<ChessSquare> possibleMove = new ArrayList<ChessSquare>();
        while (currentRow > -1 && currentColumn > -1) {
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

    static String getNamePiece(char type) {
        String name = "";
        switch (type) {
            case 'P':
                name = "Pawn";
                break;
            case 'H':
                name = "Knight";
                break;
            case 'K':
                name = "King";
                break;
            case 'Q':
                name = "Queen";
                break;
            case 'R':
                name = "Rook";
                break;
            case 'B':
                name = "Bishop";
                break;               
        }
         return name;
    }
}
