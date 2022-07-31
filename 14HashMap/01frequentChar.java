import static java.lang.System.*;
import java.lang.*;
import java.util.Scanner;
import java.io.*;
import java.util.Stack;
import java.util.Queue;
import java.util.HashMap;

class Main{
    
    public static void main(String[] args) throws IOException{
        initializeIO();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashMap<Character,Integer> hm = new HashMap<>();

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);

            if(!hm.containsKey(ch))
            {
                // insert the key
                hm.put(ch,1);
            }else{
                hm.put(ch,hm.get(ch)+1);
            }
        }

        char ans = ' ';
        int freq = 0;

        for(Character ch : hm.keySet())
        {
            if(hm.get(ch) > freq)
            {
                ans = ch;
                freq = hm.get(ch);
            }
        }
        System.out.println(ans + " is the most frequent character with freq : " + freq);
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
