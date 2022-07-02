import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
/*
    ArrayList Intro
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<5;i++){
            nums.add(5-i);
        }

        System.out.println(nums);

        // sorting an arraylist
        Collections.sort(nums);


        System.out.println(nums);

        // soring in reverse order
        Collections.sort(nums, Collections.reverseOrder());

        System.out.println(nums);


        // iterating over arraylist

        for(int x : nums){
            System.out.print(x + " ");
        }
        System.out.println();

        // ArrayList of objects

        ArrayList<int[]> matrix = new ArrayList<>();
        for(int i=0;i<5;i++){
            int[] vals = {1,2};
            matrix.add(vals);
        }

        // matrix is now   {{1,2}
                         // {1,2}
                         // {1,2}
                         // {1,2}
                         // {1,2}}
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
