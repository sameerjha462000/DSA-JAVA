import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- print keyPadCombinations without using arraylist...
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        getKpc(s);
    }

    public static void getKpc(String s){
        getKpcHelper(s,"");
    }

    public static void getKpcHelper(String qsf, String asf){
        if(qsf.length() == 0)
        {
            System.out.println(asf);
            return;
        }

        char ch = qsf.charAt(0);
        String codeForCh = map(ch);

        for(int i=0;i<codeForCh.length();i++){
            char codeChar = codeForCh.charAt(i);
            getKpcHelper(qsf.substring(1),asf+codeChar);
        }
    }

    public static String map(char ch){
        String[] map = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

        int index = ch-'0';

        return map[index];
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
