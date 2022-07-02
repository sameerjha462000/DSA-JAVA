import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

// Basics of Strings in JAVA
class Main{
    public static void main(String ...args){
        initializeIO();

        // Intern pool is in Heap...
        // Shell is also always in Heap, however the name of the String is always in stack and stores the reference of the shell

        String s = "hello"; // shell and String both in intern pool
        // s stores the reference of the shell, let us say 4K
        String _s = new String("hello"); // shell outside the intern pool but String in the intern pool

        /*
            In JAVA, Strings are immutable but their reference is mutable...
            In C++, we write string(notice 's' lowercase)
        */
        s += " World";
        System.out.println(s);
        System.out.println(s.length()); // gives the length of String

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i); // for accessing character at index i
            System.out.print(ch+" ");
        }
        System.out.println();

        // You cannot change character at any index as Strings are immutable

        String empty = ""; // blank string in String constant pool
        System.out.println(empty.isEmpty()); // to check whether the String is empty or not

        for(int i = 0;i<10;i++){
            //You feel this is O(N) but this is O(N*N) because everytime you add
            // something to the String a new String is created in String constant pool
            // and then copying happens character by character
            // so T.C = 1 + ... + N = (N * (N + 1))/2
            empty += 'a';
        }
        System.out.println(empty);

        // CONVERTING STRING TO CHARACTER ARRAY
        String name = "Abhishek Jha...";
        char[] nameSplitted = name.toCharArray();

        System.out.println(Arrays.toString(nameSplitted));


        // CONVERTING TO UPPER AND LOWER CASE

        String upper = name.toUpperCase();
        String lower = name.toLowerCase();
        // these methds do not change the original String
        System.out.println(name);
        System.out.println(upper);
        System.out.println(lower);

        // CHECKING TWO STRINGS ARE EQUAL OR NOT
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        // == method checks the shell address 
        System.out.println(s1 == s2); // they share same shell
        System.out.println(s1 == s3); // they have same content but different shell address
        System.out.println(s2 == s3);

        // s1.equals(s2) method
        System.out.println(s1.equals(s2)); // true
        System.out.println(s2.equals(s3)); // true
        System.out.println(s1.equals(s3)); // true

        // In questions we never use == method
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
