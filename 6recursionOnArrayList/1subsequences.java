import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- find subsequences of a String with distinct characters
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        getSubs(s);
    }

    public static void getSubs(String s){
        ArrayList<String> ans = null;
        int choice = 2;
        if(choice == 1)
            ans = getSubsHelper1(s); // works even for null Strings
        else
            ans = getSubsHelper2(s); // will not work for null Strings 
        System.out.println(ans);
    }

    public static ArrayList<String> getSubsHelper1(String s){

        if(s.length() == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        } 

        // find the subsequences of s.substring(1)
        char ch = s.charAt(0);
        ArrayList<String> rres = getSubsHelper1(s.substring(1));
        int size = rres.size();
        for(int i=0;i<size;i++){
            rres.add(ch + rres.get(i));
        }
        return rres;
    }

    public static ArrayList<String> getSubsHelper2(String s){

        // In case the String has length has length == 1, then the number of subsequences are 2
        if(s.length() == 1){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            base.add(s);
            return base;
        }

        // find the subsequences of s.substring(1)
        char ch = s.charAt(0);
        ArrayList<String> rres = getSubsHelper2(s.substring(1));
        int size = rres.size();
        for(int i=0;i<size;i++){
            rres.add(ch + rres.get(i));
        }
        return rres;
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
