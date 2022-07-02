import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
/*
    problem -- https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/remove-primes-official/ojquestion
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(i);
        }
        primesRemover(nums);

        System.out.println(nums);
    }

    public static void primesRemover(ArrayList<Integer> nums){

        // This would give error think why when you revisit
        // int size = nums.size();
        // for(int i=0;i<size;i++){
        //     if(isPrime(nums.get(i)))
        //         nums.remove(i);
        // }

        int size = nums.size();
        for(int i = size-1;i>=0;--i){
            if(isPrime(nums.get(i))){
                nums.remove(i);
            }
        }
    }

    public static boolean isPrime(int n){
        // System.out.println("@");
        if(n <= 1)
            return false;
        if(n <= 3)
            return true;

        if(n % 2 == 0 || n % 3 == 0)
            return false;


        // use this
        for(int i = 5;i <= n;i = i + 6){
            if(i != n && i + 2 != n){
                if(n % i == 0 || n % (i + 2) == 0)
                    return false;
            }
        }

        // or this

        // for(int i = 5;i*i <= n;i = i + 6){
        //     if(n % i == 0 || n % (i + 2) == 0)
        //         return false;
        // }

        // But do not use this, there is a serious flaw in this algo
        // it can happen that i == n or i + 2 == n, check for ex 11 and 13
        // for(int i = 5;i <= n;i = i + 6){
        //     if(n % i == 0 || n % (i + 2) == 0)
        //         return false;
        // }

        return true;
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
