package jalasoft.bootcamp.chessgame;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK_WHITE = "\u001B[47;30m ";
    public static final String ANSI_WHITE_BLACK = "\u001B[40;30m ";


    public static void main(String[] args) {
        int actualRow, actualColumn;
        int selectedRow, selectedColumn;
        String namePlayer = "";
        char colorPlayer = 'W';
        Boolean turn = true;

        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        RulesGame rules = new RulesGame();
        Player actualPlayer = new Player();

        ArrayList<ChessSquare> listPositionMove;
        ArrayList<Player> listPlayers = new ArrayList<Player>();
        ArrayList<ChessSquare> listPositionMate = new ArrayList<ChessSquare>();

        for (int i = 0; i < 2; i++) {
            System.out.println(ANSI_BLACK + "Player " + i + "... Enter your name" + ANSI_RESET);
            namePlayer = sn.next().toUpperCase();
            listPlayers.add(new Player(namePlayer, turn, colorPlayer));
            turn = false;
            colorPlayer = 'B';
        }

        for (Player play : listPlayers) {
            if (play.getColorPiece() == 'W') {
                System.out.println(ANSI_RED + play.getName() + " juegas con fichas ROJAS" + ANSI_RESET);
            } else {
                System.out.println(ANSI_BLUE + play.getName() + " juegas con fichas AZULES" + ANSI_RESET);
            }
        }

        System.out.println(ANSI_RED + "GAME STARTS!!!" + ANSI_RESET);
        boardGame.initGame();
        boardGame.showBoard();
        while (1 != 2) {
            for (Player play : listPlayers) {
                if (play.isTurn() == Boolean.TRUE) {
                    actualPlayer = play;
                } else {
                    play.setTurn(Boolean.TRUE);
                }
            }
            if (actualPlayer.isTurn() == true) {
                do {
                    if (actualPlayer.getColorPiece() == 'W') {
                        System.out.println(ANSI_RED + actualPlayer.getName() + " your turn... Choose a piece... " + ANSI_RESET);
                        System.out.println(ANSI_RED + "Enter the row to choose your piece... " + ANSI_RESET);
                        actualRow = sn.nextInt();
                        System.out.println(ANSI_RED + "Enter the column to choose your pieces... " + ANSI_RESET);
                        actualColumn = sn.nextInt();
                    } else {
                        System.out.println(ANSI_BLUE + actualPlayer.getName() + " your turn... Choose a piece... " + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "Enter the row to choose your piece... " + ANSI_RESET);
                        actualRow = sn.nextInt();
                        System.out.println(ANSI_BLUE + "Enter the column to choose your pieces... " + ANSI_RESET);
                        actualColumn = sn.nextInt();
                    }
                    listPositionMove = boardGame.capturePiece(new ChessSquare(actualRow, actualColumn));
                    
                } while ((actualRow<0 || actualRow>8)
                        || (actualColumn<0 || actualColumn>8)
                        || !boardGame.validateColorPiece(new ChessSquare(actualRow, actualColumn), actualPlayer)
                        || (listPositionMove.size()<=0 )); //|| (listPositionMove.size()==0 || listPositionMove!=null)

                //listPositionMate = rules.listCheckMate(boardGame.spots, actualPlayer.getColorPiece());
                 //if (listPositionMate != null || listPositionMate.size() > 0) {
                //for (ChessSquare mater : listPositionMate) {
                //System.out.println(ANSI_BLACK + "Row: " + mater.getRow() + "Column: " + mater.getColumn() + ANSI_RESET);
                //}
                //}
                boardGame.showSelectedPiece(new ChessSquare(actualRow, actualColumn));
                //listPositionMove = boardGame.capturePiece(new ChessSquare(actualRow, actualColumn));

                if(listPositionMove.size()>0 || listPositionMove!=null)
                if (actualPlayer.getColorPiece() == 'W') {
                    System.out.println(ANSI_RED + actualPlayer.getName() + " your possibles movements are... " + ANSI_RESET);
                } else {
                    System.out.println(ANSI_BLUE + actualPlayer.getName() + " your possibles movements are... " + ANSI_RESET);
                }

                for (ChessSquare mover : listPositionMove) {
                    if (actualPlayer.getColorPiece() == 'W') {
                        System.out.println(ANSI_RED + "( " + mover.getRow() + " ,  " + mover.getColumn() + ")" + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_BLUE + "( " + mover.getRow() + " ,  " + mover.getColumn() + ")" + ANSI_RESET);
                    }
                }

                do {
                    if (actualPlayer.getColorPiece() == 'W') {
                        System.out.println(ANSI_RED + "Choose your movement... " + ANSI_RESET);
                        System.out.println(ANSI_RED + "Enter the row to move your piece... " + ANSI_RESET);
                        selectedRow = sn.nextInt();
                        System.out.println(ANSI_RED + "Enter the column to move your piece... " + ANSI_RESET);
                        selectedColumn = sn.nextInt();
                    } else {
                        System.out.println(ANSI_BLUE + "Choose your movement... " + ANSI_RESET);
                        System.out.println(ANSI_BLUE + "Enter the row to move your piece... " + ANSI_RESET);
                        selectedRow = sn.nextInt();
                        System.out.println(ANSI_BLUE + "Enter the column to move your piece... " + ANSI_RESET);
                        selectedColumn = sn.nextInt();
                    }
                } while (!boardGame.validateMoves(listPositionMove, new ChessSquare(selectedRow, selectedColumn)));

                
               
                boardGame.spots = rules.putPiece(new ChessSquare(actualRow, actualColumn), new ChessSquare(selectedRow, selectedColumn), boardGame.spots, actualPlayer);
                if (actualPlayer.getWinner()) {
                    if (actualPlayer.getColorPiece() == 'W') {
                        System.out.println(ANSI_RED + actualPlayer.getName() + " WINS !!!!!" + ANSI_RESET);
                        boardGame.showBoard();
                    } else {
                        System.out.println(ANSI_BLUE + actualPlayer.getName() + " WINS !!!!!" + ANSI_RESET);
                    }
                    break;
                } else {
                    actualPlayer.setTurn(Boolean.FALSE);
                }
                boardGame.showBoard();
            }
        }
    }
}
