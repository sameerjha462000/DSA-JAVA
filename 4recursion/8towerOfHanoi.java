import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion/toh-official/ojquestion
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int source = scn.nextInt();
        int destination = scn.nextInt();
        int helper = scn.nextInt();
        towerOfHanoi(n,source,destination,helper);
    }
    public static void towerOfHanoi(int n, int source, int destination, int helper){
        // Invalid base case
        if(n == 0)
            return;

        // move the first n-1 disks from source to helper
        towerOfHanoi(n-1,source,helper,destination); // faith

        // Now that you have moved first n-1 disks source to helper,
        // Move the nth disk from source to destination directly

        System.out.println(n + "[ " +source + " -> " + destination + " ]"); // My work

        // Now again move those disks which are on helper back to destination

        towerOfHanoi(n-1,helper,destination,source); // faith again

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
