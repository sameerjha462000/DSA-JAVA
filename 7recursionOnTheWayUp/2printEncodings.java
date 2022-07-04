import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- print encodings
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        printEncodings(s);
    }

    public static void printEncodings(String s){
        String map ="_abcdefghijklmnopqrstuvwxyz";
        printEncodingsHelper(s,"",map);
    }

    public static void printEncodingsHelper(String qsf,String asf,String map){
        if(qsf.length()==0)
        {
            System.out.println(asf);
            return;
        }

        char ch = qsf.charAt(0);
        int tmp = ch-'0';

        if(tmp == 0)
            return ;

        printEncodingsHelper(qsf.substring(1),asf+map.charAt(tmp),map);

        if(qsf.length()>=2){
            char chAgain = qsf.charAt(1);
            int tmpAgain = chAgain-'0';

            tmpAgain = tmp*10+tmpAgain;
            if(tmpAgain <= 26)
            printEncodingsHelper(qsf.substring(2),asf+map.charAt(tmpAgain),map);
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
