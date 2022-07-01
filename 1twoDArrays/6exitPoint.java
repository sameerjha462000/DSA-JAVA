import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    We are given a binary maze. The player enters from (0,0).
    The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
    We are required to find the exxit point of the player.
*/
class Main{
    private static class pair{
        int first; 
        int second;

        @Override
        public String toString(){
            return "<" + first + ", " + second + ">";
        }
    }
    public static void main(String ...args){
        initializeIO();
        int[][] nums = {{0, 0, 1, 0},
                        {1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {1, 0, 1, 0}};
        pair p = exitPoint(nums);
        System.out.println(p);
    }
    private static pair exitPoint(int[][] nums){
        pair ans = new pair();

        int nr = nums.length;
        int nc = nums[0].length;

        // set the starting point
        int r = 0;
        int c = 0;

        // There are four directions, set the initial direction as 0
        int direction = 0;
        while(r >= 0 && r < nr && c >= 0 && c < nc){
            if(direction == 0){
                // this means that we are facing towards the right wall
                // so move rightwards
                ++c;
            }
            if(direction == 1){
                // this means that we are facing towards the bottom wall
                // so move downwards
                ++r;
            }
            if(direction == 2){
                // this means that we are facing towards the left wall
                // so move leftwards
                --c;
            }
            if(direction == 3){
                // this means that we are facing towards top wall
                // so move upwards
                --r;
            }

            // after all this it might happen that we would have hit a 1
            // but keep in mind that we might have also crossed the boundary

            if(r >= 0 && r < nr && c >= 0 && c < nc && nums[r][c] == 1)
            {
                // change the direction
                direction = (direction + 1) % 4;
            }
        }

        // We are out of loop so any one of r or c must be OutOfIndex
        if(r < 0)
            ++r;
        if(r >= nr)
            --r;
        if(c < 0)
            ++c;
        if(c >= nc)
            --c;

        ans.first = r;
        ans.second = c;
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
