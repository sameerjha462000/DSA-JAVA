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
        displayReverse(nums);
    }
    public static void displayReverse(int[] nums){
        int choice = 3;

        // if(choice == 1)
            // displayReverseHelper1(nums,0); // using valid base case
        // else if(choice == 2)
            displayReverseHelper2(nums,0); // using invalid base case
        // else if(choice == 3)
            // displayReverseHelper3(nums,nums.length-1); // using valid base case
        // else
            // displayReverseHelper4(nums,nums.length-1); // using invalid base case
    }

    public static void displayReverseHelper1(int[] nums, int idx){
        // valid base case
        if(idx == nums.length-1)
        {
            System.out.println(nums[idx]); // My work at base case
            return;
        }
        displayReverseHelper1(nums,idx+1); // first let recursion print the elements from idx+1 in reverse order
        System.out.println(nums[idx]); // My work
    }

    public static void displayReverseHelper2(int[] nums, int idx){
        // Invalid base case
        if(idx == nums.length)
            return;
        displayReverseHelper2(nums,idx + 1); // faith
        System.out.println(nums[idx]); // My work
    }
    
    public static void displayReverseHelper3(int[] nums,int idx){
        // valid base case
        if(idx == 0)
        {
            System.out.println(nums[idx]); // My work at base case
            return;
        }

        System.out.println(nums[idx]); // My work 
        displayReverseHelper3(nums,idx-1); // faith
    }

    public static void displayReverseHelper4(int[] nums,int idx){
        // invalid base case
        if(idx == -1)
            return;
        System.out.println(nums[idx]); // My work
        displayReverseHelper4(nums,idx-1); // faith
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
