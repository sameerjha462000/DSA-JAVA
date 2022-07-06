import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- classic NQueens problem...
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        NQueens(n);
    }

    public static void NQueens(int n){
         int[][] chess = new int[n][n]; // initially all the cells are filled with zero

         NQueensHelper(chess,0);
    }

    // helper function to check whether a position is safe or not...
    public static boolean isSafe(int[][] chess,int row, int col){
        int n = chess.length;

        if(row < 0 || row > n-1 || col < 0 || col > n-1 || chess[row][col] == 1)
            return false;

        // check whether this column has another queen or not

        for(int j=row;j>=0;j--){
            if(chess[j][col] == 1)
                return false;
        }

        // check whether there is a queen diagonally

        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
            if(chess[i][j] == 1)
                return false;
        }

        for(int i=row,j=col;i>=0 && j<n;i--,j++){
            if(chess[i][j] == 1)
                return false;
        }
        return true;
    }

    public static void NQueensHelper(int[][] chess,int row){
        if(row == chess.length)
        {
            // print the board when configuration is achieved...
            print(chess);

            // print the next line so that gap between each board is "\n"...
            System.out.println();
            return;
        }

        for(int col=0;col<chess[0].length;col++){
            // if it is safe then place queen on the (row,i) and make call to the next row
            if(isSafe(chess,row,col))
            {
                chess[row][col] = 1; // mark the position...
                NQueensHelper(chess,row+1);
                chess[row][col] = 0; // unmark the position backtrack...
            }
        }
        return;
    }

    // Helper function to print the board...
    public static void print(int[][] chess){
        int n = chess.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(chess[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void initializeIO(){
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}
