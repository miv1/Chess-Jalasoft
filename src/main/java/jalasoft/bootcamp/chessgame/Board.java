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
    private String spots [][] = new String[8][8];
    
    public void initGame()
    {
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (i==2 || i==6)
                {
                    spots[i][j]=" P  ";
                }
                else if((i==0 && j==0)||(i==0 && j==7)||(i==7 && j==0)||(i==7 && j==7))
                {
                    spots[i][j]=" T  ";
                }  
                else if((i==0 && j==1)||(i==0 && j==6)||(i==7 && j==1)||(i==7 && j==6))
                {
                    spots[i][j]=" K  ";
                }  
                else if((i==0 && j==2)||(i==0 && j==5)||(i==7 && j==2)||(i==7 && j==5))
                {
                    spots[i][j]=" B  ";
                }
                else if((i==0 && j==3)||(i==7 && j==4))
                {
                    spots[i][j]=" Q  ";
                }
                else if((i==0 && j==4)||(i==7 && j==3))
                {
                    spots[i][j]=" Ki ";
                }
                else{
                    spots[i][j]="    ";
                }
            }
        }
    }
    
    public void showBoard(){
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(spots[i][j]+ "|");
                
            }
            System.out.println("");
        }
    }
    

//    public Board() {
//        super();
//        for(int i=0; i<spots.length; i++){
//            for(int j=0; j<spots.length; j++){
//                this.spots[i][j] = new Spot(i, j);
//                
//            }
//        }
//    }

//    public Spot getSpot(int x, int y) {
//        return spots[x][y];
//    }

}
