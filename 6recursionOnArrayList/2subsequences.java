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
            ans = getSubsHelper1(s,s.length()-1);
        else
            ans = getSubsHelper2(s,s.length()-1);
        System.out.println(ans);
    }

    public static ArrayList<String> getSubsHelper1(String s, int idx){
        if(idx == -1)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> rres = getSubsHelper1(s,idx-1);
        char ch = s.charAt(idx);

        int size = rres.size();
        for(int i=0;i<size;i++){
            rres.add(rres.get(i)+ch);
        }
        return rres;
    }

    public static ArrayList<String> getSubsHelper2(String s, int idx){
        if(idx == 0)
        {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            base.add(""+s.charAt(idx));
            return base;
        }

        ArrayList<String> rres = getSubsHelper2(s,idx-1);
        char ch = s.charAt(idx);

        int size = rres.size();
        for(int i=0;i<size;i++){
            rres.add(rres.get(i)+ch);
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
