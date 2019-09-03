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
public class RulesGame {
     public Piece[][] putPiece(ChessSquare actualPosition,ChessSquare selectPosition,Piece[][] spots){
        //Piece actualPiece = spots[actualPosition.getRow()][actualPosition.getColumn()];
        //Piece movePiece = spots[selectPosition.getRow()][selectPosition.getColumn()];
        
        //if(!actualPiece.getColor().equals(movePiece.getColor())){
            spots[selectPosition.getRow()][selectPosition.getColumn()]=spots[actualPosition.getRow()][actualPosition.getColumn()];
        //}
        //else if(){
       // }
           
        
         
        
        spots[actualPosition.getRow()][actualPosition.getColumn()]=null;
        
        return spots;
    }
}
