import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
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
    public static void display(int[][] nums){
        // find no of rows and columns
        int nr = nums.length;
        int nc = nums[0].length;

        // display linewise

        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        initializeIO();
        Scanner scn = new Scanner(System.in);

        // taking number of rows and columns
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        // declaring the array

        int[][] nums = new int[nr][nc]; // is always heap allocated

        // Now taking elements of arrays as input

        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j] = scn.nextInt();
            }
        }

        // Now print the array using display function

        display(nums);
    }
}
