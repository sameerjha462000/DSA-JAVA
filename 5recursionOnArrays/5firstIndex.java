import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- find first index of an element in an array
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

        firstIndex(nums,x);
    }

    public static void firstIndex(int[] nums,int x){
        int ans = -1;
        int choice = 4;


        // switch for cases
        if(choice == 1)
            ans = firstIndexHelper1(nums,x,0);
        else if(choice == 2)
            ans = firstIndexHelper2(nums,x,0);
        else if(choice == 3)
            ans = firstIndexHelper3(nums,x,nums.length-1);
        else
            ans = firstIndexHelper4(nums,x,nums.length-1);


        if(ans == -1)
        {
            System.out.println("Element not found...");

        }else{
            System.out.println("Element first found at " + ans);
        }
    }

    public static int firstIndexHelper1(int[] nums,int x,int idx){

        // Invalid base case
        if(idx == nums.length)
            return -1;

        // since we are coming from 0th index and if we find x here then return idx
        if(nums[idx] == x) 
            return idx;
        else
            // nums[idx] != x so we hope to find x after idx so call firstIndexHelper1
            return firstIndexHelper1(nums,x,idx+1); // faith
    }

    public static int firstIndexHelper2(int[] nums,int x, int idx){

        // Valid base case
        if(idx == nums.length-1)
        {
            if(nums[idx] == x)
                return idx;
            else
                return -1;
        }

        // if found x then return idx
        if(nums[idx] == x)
            return idx;
        else
            return firstIndexHelper2(nums,x,idx+1);
    }

    public static int firstIndexHelper3(int[] nums,int x,int idx){

        // Invalid base case
        if(idx == -1)
            return -1;

        int ans = firstIndexHelper3(nums,x,idx-1); // faith
        if(ans != -1)
            return ans;
        if(nums[idx] == x)
            return idx;
        return -1;
    }

    public static int firstIndexHelper4(int[] nums,int x, int idx){

        // Valid base case
        if(idx == 0){
            if(nums[idx] == x)
                return 0;
            else
                return -1;
        }
        int ans = firstIndexHelper4(nums,x,idx-1);

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
