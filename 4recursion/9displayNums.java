import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- display an array using recursion
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = scn.nextInt();
        }
        display(nums);
    }
    public static void display(int[] nums){
        // we need to pass the starting index 
        displayHelper(nums,0);
    }
    public static void displayHelper(int[] nums,int i){
        // But what about the base case
        // There can be two of 'em -- Invalid and Valid
        // Let us take the Invalid base case
        // when index is invalid -- i is >= nums.length]


        // if(i == nums.length)
        //     return;

        // Now let us also discuss the valid index approach

        if(i == nums.length-1){
            System.out.println(nums[i]);
            return;
        }

        // display the element at ith index
        System.out.println(nums[i]); // My work

        // Now let recursion display the array ith index
        displayHelper(nums,i+1); // faith at work
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
