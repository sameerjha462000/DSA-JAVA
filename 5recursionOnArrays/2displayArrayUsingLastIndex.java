import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- display an array using recursion using last index as parameter
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

        // displayHelper1(nums,nums.length-1);
        displayHelper2(nums,nums.length-1);
    }

    // Helper function1 of display (it uses invalid base case)
    public static void displayHelper1(int[] nums,int idx){
        // This is an invalid base case
        if(idx == -1)
            return ;
        displayHelper1(nums,idx - 1); // faith 
        System.out.println(nums[idx]); // My work
    }

    // Helper function2 of display (it uses valid base case)
    public static void displayHelper2(int[] nums,int idx){
        // valid base case
        if(idx == 0){
            System.out.println(nums[idx]); // This time i had to do work even at base case
            return;
        }
        displayHelper2(nums,idx -1); // faith
        System.out.println(nums[idx]); // My work
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
