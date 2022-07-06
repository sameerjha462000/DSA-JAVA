import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- target sum subset but not getting submitted on nados...
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        targetSumSubset(nums,target);
    }

    public static void targetSumSubset(int[] nums,int target){
        targetSumSubsetHelper(nums,target,0,"");
    }

    public static void targetSumSubsetHelper(int[] nums,int target, int idx, String asf){
        if(idx == nums.length)
        {
            if(target == 0)
            {
                System.out.println(asf+".");
                
            }
            return;
        }

        targetSumSubsetHelper(nums,target-nums[idx],idx+1,asf+nums[idx]+", ");
        targetSumSubsetHelper(nums,target,idx+1,asf);
        
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
