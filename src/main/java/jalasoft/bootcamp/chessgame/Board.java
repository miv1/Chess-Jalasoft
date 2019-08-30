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
public class Board {
    Piece spots[][] = new Piece[8][8];
    
    public void initGame()
    {
        Piece newPiece=new Piece();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (i==1)
               {
                    //Piece pieceSpot=new Piece("P","W",new ChessSquare(i,j));
                    spots[i][j]=newPiece.putPiece('P',"B",new ChessSquare(i,j));
                }
                else if( i==6){
                     spots[i][j]=newPiece.putPiece('P',"W",new ChessSquare(i,j));
                }
                else if((i==0 && j==0)||(i==0 && j==7))
                {
                    spots[i][j]=newPiece.putPiece('T',"B",new ChessSquare(i,j));
                }
                else if((i==7 && j==0)||(i==7 && j==7))
                {
                    spots[i][j]=newPiece.putPiece('T',"W",new ChessSquare(i,j));
                }  
                else if((i==0 && j==1)||(i==0 && j==6))
                {
                    spots[i][j]=newPiece.putPiece('H',"B",new ChessSquare(i,j));
                } 
                else if((i==7 && j==1)||(i==7 && j==6))
                {
                    spots[i][j]=newPiece.putPiece('H',"W",new ChessSquare(i,j));
                } 
                else if((i==0 && j==2)||(i==0 && j==5))
                {
                    spots[i][j]=newPiece.putPiece('B',"B",new ChessSquare(i,j));
                }
                else if((i==7 && j==2)||(i==7 && j==5))
                {
                    spots[i][j]=newPiece.putPiece('B',"W",new ChessSquare(i,j));
                }
                else if((i==0 && j==3))
                {
                    spots[i][j]=newPiece.putPiece('Q',"B",new ChessSquare(i,j));
                }
                else if((i==7 && j==4))
                {
                    spots[i][j]=newPiece.putPiece('Q',"W",new ChessSquare(i,j));
                }
                else if((i==0 && j==4))
                {
                    spots[i][j]=newPiece.putPiece('K',"B",new ChessSquare(i,j));
                }
                     else if((i==7 && j==3))
                {
                    spots[i][j]=newPiece.putPiece('K',"W",new ChessSquare(i,j));
                }
                else{
                    Piece pieceSpot=newPiece.putPiece(' '," ",new ChessSquare(i,j));
                    spots[i][j]=pieceSpot;
                }
            }
        }
    }
    
    public void showBoard(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(this.spots[i][j].getTypePiece()+ "|");
                
            }
            System.out.println("");
        }
    }


}
