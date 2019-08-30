/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

/**
 *
 * @author BootCamp LP
 */
public class Game {

    private Board board = new Board();
   
    public static void main(String[] args) {
        Board boardGame = new Board();

        boardGame.initGame();
        boardGame.showBoard();
    }
           
}
