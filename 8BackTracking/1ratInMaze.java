import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

/*
    problem -- rate in a maze...
*/
class Main{
    public static void main(String ...args){
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] maze = new int[nr][nc];

        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                maze[i][j] = scn.nextInt();
            }
        }

        ratInMaze(maze);
    }

    public static void ratInMaze(int[][] maze){
        int nr = maze.length;
        int nc = maze[0].length;
        boolean[][] visited = new boolean[nr][nc];

        int choice = 1;
        if(choice == 1)
            ratInMazeHelperReactive(maze,0,0,"",visited);
        else
            ratInMazeHelperProActive(maze,0,0,"",visited);
    }

    public static void ratInMazeHelperReactive(int[][] maze,int sr,int sc,String asf,boolean[][] visited){

        // Invalid base case
        if(sr < 0 || sr >= maze.length || sc < 0 || sc >= maze[0].length || maze[sr][sc] == 1 || visited[sr][sc] == true)
            return;

        // Valid base case
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            System.out.println(asf);
            return;
        }


        visited[sr][sc] = true;

        ratInMazeHelperReactive(maze,sr-1,sc,asf+"t",visited);
        ratInMazeHelperReactive(maze,sr,sc-1,asf+"l",visited);
        ratInMazeHelperReactive(maze,sr+1,sc,asf+"d",visited);
        ratInMazeHelperReactive(maze,sr,sc+1,asf+"r",visited);

        visited[sr][sc] = false; // backtrack
    }

    // This is proactive approach... so no inavlid base case would be encountered in this case
    public static void ratInMazeHelperProActive(int[][] maze,int sr,int sc,String asf,boolean[][] visited){

        // Valid base case
        if(sr ==  maze.length-1 && sc == maze[0].length-1)
        {
            System.out.println(asf);
            return;
        }

        visited[sr][sc] = true;

        // think before moving
        if(sr-1 >= 0 && maze[sr-1][sc] != 1 && visited[sr-1][sc] == false)
            ratInMazeHelperProActive(maze,sr-1,sc,asf+"t",visited);

        if(sc-1 >= 0 && maze[sr][sc-1] != 1 && visited[sr][sc-1] == false)
            ratInMazeHelperProActive(maze,sr,sc-1,asf+"l",visited);

        if(sr+1 < maze.length && maze[sr+1][sc] != 1 && visited[sr+1][sc] == false)
            ratInMazeHelperProActive(maze,sr+1,sc,asf+"d",visited);

        if(sc+1 < maze[0].length && maze[sr][sc+1] != 1 && visited[sr][sc+1] == false)
            ratInMazeHelperProActive(maze,sr,sc+1,asf+"r",visited);

        visited[sr][sc] = false; // backtrack

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
