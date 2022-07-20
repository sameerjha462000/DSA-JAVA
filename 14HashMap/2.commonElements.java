import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.HashMap;

class Main{
    private static int[] readIntArray(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine());

        String[] values = br.readLine().split(" ");

        int[] nums = new int[n];

        for(int i=0;i<n;i++)
        {
            nums[i] = Integer.parseInt(values[i]);
        }

        return nums;
    }
    public static void main(String[] args) throws IOException{
        initializeIO();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] one = readIntArray(br);
        int[] two = readIntArray(br);

        /** count common elements
         **/

        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int x : one)
        {
            if(!hm.containsKey(x))
            {
                hm.put(x,1);
            }
            else{
                hm.put(x,hm.get(x)+1);
            }
        }

        for(int j : two)
        {
            if(hm.containsKey(j))
            {
                System.out.println(j);
                hm.remove(j);
            }
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
