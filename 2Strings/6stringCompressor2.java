import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/string-compression-official/ojquestion
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(compressorWithFrequency(s));
    }
    public static String compressorWithFrequency(String s){
        String ans = "" + s.charAt(0);
        int count = 1;

        for(int i=1;i<s.length();i++){
            char prev = s.charAt(i-1);
            char curr = s.charAt(i);

            if(curr != prev){
                if(count > 1){
                    ans += count;
                }
                ans += curr;
                count = 1;
            }else{
                ++count;
            }

        }
        if(count > 1)
            ans += count;
        return ans;
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
