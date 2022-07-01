import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void fill(int[][] nums,Scanner scn){
        int nr = nums.length;
        int nc = nums[0].length;

        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j] = scn.nextInt();
            }
        }
    }
    public static void main(String ...args){
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] nums = new int[nr][nc]; // by default elements are zero
        fill(nums,scn);
        print(nums);
        
    }
    public static void print(int[][] nums){
        for(int[] vals : nums){
            System.out.println(Arrays.toString(vals));
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
