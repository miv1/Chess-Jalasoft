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
public class LegalMoves {

    public LegalMoves(int row, int col, String typeMove) {
        this.row = row;
        this.col = col;
        this.typeMove = typeMove;
    }
    int row;
    int col;
    String typeMove; //go ahead, eat
}
