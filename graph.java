import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

class edge{
	int sr;
	int ds;
	int wt;

	edge()
	{}
	edge(int sr,int ds,int wt)
	{
		this.sr = sr;
		this.ds = ds;
		this.wt = wt;
	}

	@Override
	public String toString()
	{
		return "["+sr+" -> "+ds+"] @ "+wt;
	}
}

class graph{
	int v;
	int e;
	ArrayList<edge> g[];

	graph(){}
	graph(int v,int e)
	{
		this.v = v;
		this.e = e;

		g = new ArrayList[v];

		Scanner scn = new Scanner(System.in); // cannot use this scanner as niche waala scanner would flush everything in "input.txt" file so we would get error
    // You either give "v" and "e" throught "input.txt" and the edges through "terminal" OR give "v" and "e" through terminal and edges through "input.txt"
    // But the main question is why this works, This is because when we use Scanner it flushes the entire stream and Thus if we try to input from both the 
    // scanners, they would use same streams so when one scanner is finished doing its work it flushes off the entire stream...
		while(e-- != 0)
		{

			int sr = scn.nextInt();
			int ds = scn.nextInt();
			int wt = scn.nextInt();
			addEdge(sr,ds,wt);
		}
	}

	void addEdge(int sr,int ds,int wt)
	{
		edge e = new edge(sr,ds,wt);
		if(g[sr]==null)
			g[sr]=new ArrayList<>();
		g[sr].add(e);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<g.length;i++)
		{
			if(g[i]==null)
				continue;
			sb.append(""+i);
			sb.append(" --> ");

			for(edge e : g[i])
				sb.append(e.toString()+" ,");
			sb.append("\n");
		}
		return sb.toString();
	}
}

public class MainAgain{
    public static void main(String args[]){
    	initializeIO();
    	
    	Scanner scn = new Scanner(System.in);
    	int v = scn.nextInt();
    	int e = scn.nextInt();
    	// System.out.println(v+ ""+e);
    	scn.close();
    	graph g = new graph(v,e);

    	System.out.println(g);
        
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


