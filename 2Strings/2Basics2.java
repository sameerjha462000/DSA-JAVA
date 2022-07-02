import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String ...args){
        initializeIO();
        String s = "Hello World"; // length = 11, last index = 10

        System.out.println(s.substring(0)); // goes till the end of String
        System.out.println(s.substring(11));

        /*
            s.substring() method takes arguments from 0 to s.length()
            There are two versions of this method
            1.single parameter version (like above)
            2.double parameter version (s.substring(i, j)) // goes till j-1
        */

        System.out.println(s.substring(0,5)); // hello
        System.out.println(s.substring(4,4)); // starts from 4 goes till 3 so empty

        // Let us say we want character at 4th index using substring method
        // char ch = s.substring(4,5); // as it returns a String

        String charAt4 = s.substring(4,5);
        System.out.println(charAt4);
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
