// package Game_Platform;

import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String[] args){

        Scanner input=new Scanner(System.in);
        char [][]board=new char [3][3];
        for (int row=0;row< board.length;row++){
            for (int col=0;col< board.length;col++){
                board[row][col]= ' ';
            }
        }
        char player='x';

        boolean gameOver=false;
        while(!gameOver) {
            display(board);
            System.out.println("Player "+player+": ");
            System.out.println("Enter the row and column where you want to insert  :- ");
            int row=input.nextInt();
            int col=input.nextInt();
            if (board[row][col]==' '){
                board[row][col]=player;
                gameOver=haveWin(board ,player);
                if (gameOver){
                    System.out.println("Player "+player+"  Have won the Game .");
                }else if(player=='x'){
                    player='o';
                }else{
                    player='x';
                }
            }

            else {
                System.out.println("Invalid Move. Try Again..");
            }
        }
            display(board);

    }


    static void display(char [][]board){

        for (int row=0;row< board.length;row++){
            System.out.print(" | ");
            for (int col=0;col<board[row].length;col++){
                System.out.print( board[row][col]+" | ");
            }
            System.out.println();
        }
    }

    static boolean haveWin(char [][]board,char player){
        for (int row=0;row<3;row++){
            if(board[row][0]==player && board[row][1]==player &&board[row][2]==player ){
                return true;
            }
        }


        for (int col=0;col<3;col++){
            if(board[0][col]==player && board[1][col]==player &&board[2][col]==player ){
                return true;
            }
        }

        if(board[0][0]==player &&board[1][1]==player &&board[2][2]==player ){
            return true ;
        }
        if(board[0][2]==player /*&&board[1][1]==player*/ &&board[2][0]==player ){
            return true ;
        }
        return false;
    }
}
