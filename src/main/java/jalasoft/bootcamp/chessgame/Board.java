package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;

public class Board {

    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    Piece spots[][] = new Piece[8][8];
    private ArrayList<ChessSquare> ValidMoves;

    void initGame() {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    spots[i][j] = new Pawn('P', 'B', new ChessSquare(i, j));
                } else if (i == 6) {
                    spots[i][j] = new Pawn('P', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 0) || (i == 0 && j == 7)) {
                    spots[i][j] = new Rook('R', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 0) || (i == 7 && j == 7)) {
                    spots[i][j] = new Rook('R', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 1) || (i == 0 && j == 6)) {
                    spots[i][j] = new Knight('H', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 1) || (i == 7 && j == 6)) {
                    spots[i][j] = new Knight('H', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 2) || (i == 0 && j == 5)) {
                    spots[i][j] = new Bishop('B', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 2) || (i == 7 && j == 5)) {
                    spots[i][j] = new Bishop('B', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 3)) {
                    spots[i][j] = new Queen('Q', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 3)) {
                    spots[i][j] = new Queen('Q', 'W', new ChessSquare(i, j));
                } else if ((i == 0 && j == 4)) {
                    spots[i][j] = new King('K', 'B', new ChessSquare(i, j));
                } else if ((i == 7 && j == 4)) {
                    spots[i][j] = new King('K', 'W', new ChessSquare(i, j));
                } else {
                    Piece pieceSpot = null;
                    spots[i][j] = pieceSpot;
                }
            }
        }
    }

    ChessSquare getKing(char color) {
        if (color == 'B') {
            return new ChessSquare(0,4);
        }
        return new ChessSquare(7,4);        
    }

    void showBoard() {
        System.out.print("   ");
        for (int rowName = 0; rowName < 8; rowName++) {
            System.out.print(rowName + " | ");
        }
        System.out.println();
        for (int row = 0; row < 8; row++) {
            System.out.print(row + " |");
            for (int col = 0; col < 8; col++) {
                if (this.spots[row][col] == null) {
                    System.out.print(" " + " | ");
                } else {
                    if (this.spots[row][col].getColor() == 'B') {
                        System.out.print(ANSI_BLUE + this.spots[row][col].getTypePiece() + ANSI_RESET + " | ");
                    } else {
                        System.out.print(ANSI_RED + this.spots[row][col].getTypePiece() + ANSI_RESET + " | ");
                    }

                }
            }
            System.out.println("");
        }
    }

    ArrayList<ChessSquare> capturePiece(ChessSquare actualPosition) {
        Piece pieceCapture = null;
        if ((actualPosition.getRow() > 0 && actualPosition.getRow() < 8)
                && (actualPosition.getColumn() > 0 || actualPosition.getColumn() < 8)) {
            pieceCapture = this.spots[actualPosition.getRow()][actualPosition.getColumn()];
        }
        Pawn movePawn = new Pawn();
        Bishop moveBishop = new Bishop();
        Knight moveKnight = new Knight();
        King moveKing = new King();
        Rook moveRook = new Rook();
        Queen moveQueen = new Queen();
        ValidMoves = null;
        if (pieceCapture != null) {
            switch (pieceCapture.getTypePiece()) {
                case 'P':
                    ValidMoves = movePawn.move(pieceCapture, this.spots);
                    break;
                case 'B':
                    ValidMoves = moveBishop.move(pieceCapture, this.spots);
                    break;
                case 'H':
                    ValidMoves = moveKnight.move(pieceCapture, this.spots);
                    break;
                case 'K':
                    ValidMoves = moveKing.move(pieceCapture, this.spots);
                    break;
                case 'R':
                    ValidMoves = moveRook.move(pieceCapture, this.spots);
                    break;
                case 'Q':
                    ValidMoves = moveQueen.move(pieceCapture, this.spots);
                    break;
                default:
                    ValidMoves = null;
                    break;
            }
        }
        return ValidMoves;
    }

    boolean validateColorPiece(ChessSquare posColor, Player playerColor
    ) {
        if ((posColor.getRow() >= 0 && posColor.getRow() < 8)
                && (posColor.getColumn() >= 0 && posColor.getColumn() < 8)) {
            if (this.spots[posColor.getRow()][posColor.getColumn()] != null) {
                if (this.spots[posColor.getRow()][posColor.getColumn()].getColor() == playerColor.getColorPiece()) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean validateMoves(ArrayList<ChessSquare> listMovements, ChessSquare selectePos
    ) {
        for (ChessSquare moves : listMovements) {
            if (moves.getRow() == selectePos.getRow() && moves.getColumn() == selectePos.getColumn()) {
                return true;
            }
        }
        return false;
    }
}
