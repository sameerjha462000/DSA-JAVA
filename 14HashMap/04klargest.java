import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.HashMap;
import java.util.PriorityQueue;

class MainAgain{
    
    private static void klargest(int[] nums,int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap

        for(int i=0;i<nums.length;i++)
        {
            if(i < k)
            {
                pq.add(nums[i]);
            }else{
                if(nums[i] > pq.peek())
                {
                    pq.remove();

                    pq.add(nums[i]);
                }
            }
        }

        while(!pq.isEmpty())
        {
            System.out.println(pq.remove());
        }

    }
    
    public static void main(String[] args) throws IOException{
        initializeIO();
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] nums = new int[n];

        for(int i=0;i<n;i++){
            nums[i] = scn.nextInt();
        }

        int k = scn.nextInt();

        klargest(nums,k);
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
