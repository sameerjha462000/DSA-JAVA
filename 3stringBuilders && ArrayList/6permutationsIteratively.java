import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/print-all-permutations-of-a-string-iteratively-official/ojquestion
*/
class Main{
    // We will be writing the algorithm keeping in mind that all the characters are different
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        permutations(s);
    }
    public static void permutations(String s){
        // Assuming that s.length() = N, then there are 2^N permuations 
        int n = s.length();

        int[] nums = new int[(int)Math.pow(2,n)];

        for(int i=0;i<nums.length;i++){
            nums[i] = i;
        }

        for(int i=0;i<nums.length;i++){
            int val = nums[i];

            // divide i by 2 n times to get its binary
            StringBuilder ans = new StringBuilder();
            for(int j=0;j<n;j++){
                int rem = val % 2;

                // rem can have two values -- 0 and 1
                if(rem == 1)
                    ans.append(s.charAt(n-j-1));
                else
                    ans.append("-");
                val = val / 2;
            }
            System.out.println(ans.reverse());
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
