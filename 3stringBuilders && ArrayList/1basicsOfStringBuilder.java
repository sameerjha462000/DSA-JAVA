import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    public static void main(String ...args){
        initializeIO();
        StringBuilder sb = new StringBuilder("Hello World");
        System.out.println(sb); // automatically invokes sb.toString()
        System.out.println(sb.toString());

        System.out.println(sb.charAt(4)); // o

        sb.setCharAt(0,'J');
        System.out.println(sb); // Jello World

        sb.setCharAt(0,'H'); // again "Hello World"
        System.out.println(sb);
        System.out.println("BEFORE DELETING LENGTH : " + sb.length());
        sb.deleteCharAt(4);
        System.out.println("AFTER DELETING LENGTH : " + sb.length());
        System.out.println(sb); // "Hell World"

        sb.append(" please help"); // appends to the end of the StringBuilder
        System.out.println(sb.length() + " " + sb);

        sb.reverse(); // reverses the original StringBuilder
        System.out.println(sb);
        sb = new StringBuilder("Abhishek Jha");
        sb.insert(3,"<><><>");
        System.out.println(sb);

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
