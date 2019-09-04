package jalasoft.bootcamp.chessgame;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        int actualRow, actualColumn;
        int selectedRow, selectedColumn;
        String namePlayer = "";
        String colorPlayer;
        Boolean turn = false;

        Scanner sn = new Scanner(System.in);
        Board boardGame = new Board();
        RulesGame rules = new RulesGame();
        Player actualPlayer = new Player();

        ArrayList<ChessSquare> listPositionMove;
        ArrayList<Player> listPlayers = new ArrayList<Player>();
        ArrayList<ChessSquare> listPositionMate = new ArrayList<ChessSquare>();

        for (int i = 0; i < 2; i++) {
            System.out.println(ANSI_BLACK + "Player " + i + "... Enter your name" + ANSI_RESET);
            namePlayer = sn.next();
            System.out.println(ANSI_BLACK + namePlayer + "... Enter the color of piece (B for Black / W for White)... " + ANSI_RESET);
            colorPlayer = sn.next();
            listPlayers.add(new Player(namePlayer, turn, colorPlayer.charAt(0)));
            turn = true;
        }

        System.out.println(ANSI_RED + "GAME STARTS!!!" + ANSI_RESET);
        boardGame.initGame();
        boardGame.showBoard();
        while (1!=2) {
            for (Player play : listPlayers) {
                if (play.isTurn()) {
                    actualPlayer = play;
                }
            }
            
            do{
            System.out.println(ANSI_BLACK + namePlayer + " your turn... Choose a piece... " + ANSI_RESET);
                System.out.println("Color" + actualPlayer.getColorPiece());
            System.out.println(ANSI_BLACK + "Enter the row to choose your piece... " + ANSI_RESET);
            actualRow = sn.nextInt();
            System.out.println(ANSI_BLACK + "Enter the column to choose your pieces... " + ANSI_RESET);
            actualColumn = sn.nextInt();
            }while(!boardGame.validateColorPiece(new ChessSquare(actualRow, actualColumn),actualPlayer));
            
            boardGame.showSelectedPiece(new ChessSquare(actualRow, actualColumn));
            listPositionMove = boardGame.capturePiece(new ChessSquare(actualRow, actualColumn));
            
            System.out.println(ANSI_BLACK + namePlayer + " your possibles movements are... " + ANSI_RESET);
            
            for (ChessSquare mover : listPositionMove) {
                System.out.println(ANSI_BLACK + "( " + mover.getRow() + " ,  " + mover.getColumn() + ")" + ANSI_RESET);
            }
            
            System.out.println(ANSI_BLACK + "Choose your movement... " + ANSI_RESET);
            System.out.println(ANSI_BLACK + "Enter the row to move your piece... " + ANSI_RESET);
            selectedRow = sn.nextInt(); 
            System.out.println(ANSI_BLACK + "Enter the column to move your piece... " + ANSI_RESET);
            selectedColumn = sn.nextInt();
            
            //listPositionMate = rules.listCheckMate(boardGame.spots, 'W');
            //if (listPositionMate != null || listPositionMate.size() > 0) {
                //for (ChessSquare mater : listPositionMate) {
                    //System.out.println(ANSI_BLACK + "Row: " + mater.getRow() + "Column: " + mater.getColumn() + ANSI_RESET);
                //}
            //}
            
            boardGame.spots = rules.putPiece(new ChessSquare(actualRow, actualColumn), new ChessSquare(selectedRow, selectedColumn), boardGame.spots, actualPlayer);
            if (actualPlayer.getWinner()) {
                System.out.println(actualPlayer.getName() + " WIN!!!!!");
                boardGame.showBoard();
                break;
            }
            
            boardGame.showBoard();
        }
    }
}
