import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- This is keypad combination problem...
*/

class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        getKpc(s);
    }

    public static void getKpc(String s){
        ArrayList<String> ans = getKpcHelper(s);
        System.out.println(ans);
    }

    public static ArrayList<String> getKpcHelper(String s){
        if(s.length() == 1)
        {
            ArrayList<String> base = new ArrayList<>();
            String map = map(s);

            for(int i=0;i<map.length();i++){
                base.add(""+map.charAt(i));
            }

            return base;
        }

        
        ArrayList<String> rres = getKpcHelper(s.substring(1));
        int size = rres.size();

        char ch = s.charAt(0);
        String map = map(""+ch);

        ArrayList<String> ans = new ArrayList<>();


        for(int i=0;i<map.length();i++){
            char start = map.charAt(i);

            for(int j=0;j<size;j++){
                ans.add(start+rres.get(j));
            }
        }

        return ans;
    }

    public static String map(String s){
        char ch = s.charAt(0);
        int index = ch - '0';

        String[] map = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};

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
