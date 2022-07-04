import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- find last index of x in nums
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
        int x = scn.nextInt();

        lastIndex(nums,x);
    }

    public static void lastIndex(int[] nums,int x){
        int ans = -1;
        int choice = 1;


        if(choice == 1)
            ans = lastIndexHelper1(nums,x,nums.length-1);
        else if(choice == 2)
            ans = lastIndexHelper2(nums,x,nums.length-1);
        else if(choice == 3)
            ans = lastIndexHelper3(nums,x,0);
        else
            ans = lastIndexHelper4(nums,x,0);


        if(ans == -1)
            System.out.println("Element not found...");
        else
            System.out.println("Element last found at "+ ans);
    }

    public static int lastIndexHelper1(int[] nums,int x,int idx){

        // Invalid base case
        if(idx == -1)
            return -1;

        if(nums[idx] == x)
            return idx;
        return lastIndexHelper1(nums,x,idx-1);
    }

    public static int lastIndexHelper2(int[] nums,int x,int idx){

        // Valid base case
        if(idx == 0)
        {
            if(nums[idx] == x)
                return idx;
            else
                return -1;
        }

        if(nums[idx] == x)
            return idx;
        return lastIndexHelper2(nums,x,idx-1);
    }

    public static int lastIndexHelper3(int[] nums,int x, int idx){

        // Invalid base case
        if(idx == nums.length)
            return -1;

        int ans = lastIndexHelper3(nums,x,idx+1);
        if(ans != -1)
            return ans;

        if(nums[idx] == x)
            return idx;
        return -1;
    }

    public static int lastIndexHelper4(int[] nums,int x, int idx){

        // Valid base case
        if(idx == nums.length-1){
            if(nums[idx] == x)
                return idx;
            else
                return -1;
        }

        int ans = lastIndexHelper4(nums,x,idx+1); // faith
        if(ans != -1)
            return ans;

        if(nums[idx] == x)
            return idx;
        return -1;
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
