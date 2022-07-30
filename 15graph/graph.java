import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Stack;
import java.util.Queue;
import java.util.HashMap;

class Main{
    
    private static class Edge{
        int src;
        int dest;

        int wt;

        Edge(int src,int dest,int wt)
        {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public String toString()
        {
            return "{" + src + "->" + dest + "@" + wt + "}";
        }
    }
    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int V = scn.nextInt(); // No of vertices

        int E = scn.nextInt(); // No of Edges


        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0;i < graph.length;i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        while(E--!= 0)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            // Assuming that the graph is bidirectional 

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));

        }

        for(int i = 0; i < V ;i++)
        {
            System.out.print(i+"-->");
            for(Edge e : graph[i])
            {
                System.out.print(e+"  ");
            }
            System.out.println();
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
