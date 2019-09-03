/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jalasoft.bootcamp.chessgame;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BootCamp LP
 */
public class Player {
    private String name;
    private Boolean turn;
    private char colorPiece;

    public Player() {
    }

    
    public Player(String name, boolean turn, char colorPiece) {
        this.name = name;
        this.turn = turn;
        this.colorPiece = colorPiece;
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the turn
     */
    public boolean isTurn() {
        return turn;
    }

    /**
     * @param turn the turn to set
     */
    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    /**
     * @return the colorPiece
     */
    public char getColorPiece() {
        return colorPiece;
    }

    /**
     * @param colorPiece the colorPiece to set
     */
    public void setColorPiece(char colorPiece) {
        this.colorPiece = colorPiece;
    }
}
