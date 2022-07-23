import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.HashMap;

class Main{

    private static class pair implements Comparable<pair> {
        int ff;
        int ss;

        pair(int ff,int ss)
        {
            this.ff = ff;
            this.ss = ss;
        }

        @Override
        public String toString()
        {
            return "<"+ff+", "+ss+">";
        }

        public int compareTo(pair p)
        {
            if(ff != p.ff)
            {
                return ff-p.ff;
            }else{
                return ss-p.ss;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        ArrayList<pair> nums = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x = scn.nextInt();
            int y = scn.nextInt();

            nums.add(new pair(x,y));
        }

        System.out.println(nums);

        Collections.sort(nums);

        System.out.println(nums);
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
