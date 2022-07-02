import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
/*
    ArrayList Intro
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<10;i++){
            nums.add(i+1);
        }
        
        // printing the arraylist, automatically invokes toString()
        System.out.println(nums);


        for(int i=0;i<nums.size();i++){
            System.out.print(nums.get(i) + " ");
        }
        System.out.println();

        nums.remove(5); // removes element at the 5th index
        System.out.println(nums);

        nums.set(5,6); // replaces the element at 5th index with 6
        System.out.println(nums);

        // adding at any index
        nums.add(6,7); // adds 7 at the 6th index
        System.out.println(nums);

        nums.clear(); // empties the ArrayList
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
