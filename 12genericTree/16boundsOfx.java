import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

class node{
	int data;
	ArrayList<node> children;

	node(int val){
		data = val;
		children = new ArrayList<>();
	}

	@Override
	public String toString(){
		String ans = "";
		ans += data+"->";

		for(node child : children)
		{
			ans += child.data + " ";
		}

		ans += "\n";

		for(node child: children)
		{
			ans += child.toString();
		}

		return ans;
	}
}

class pair{
	int first;
	int second;

	pair(int _first, int _second)
	{
		first = _first;
		second = _second;
	}

	@Override
	public String toString(){
		return "<"+first+", "+second+">";
	}
}

// added bounds at 67...

class Main{
	public static void main(String[] args) {
		initializeIO();
		Integer[] vals = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};

		node root = constructGT(vals);
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		pair p = new pair(Integer.MIN_VALUE,Integer.MAX_VALUE);// p.first == floor and p.second == ceil
		bounds(root,x,p); // will give values just smaller and just greater than x (even if the value is present in the tree)
		System.out.println(p);
	}

	public static void bounds(node root,int x, pair p){
		if(root.data < x)
		{
			if(root.data > p.first)
			{
				p.first = root.data;
			}
		}

		if(root.data > x) // larger values so this will store ceil
		{
			if(root.data < p.second)
			{
				p.second = root.data;
			}
		}

		for(node child : root.children)
		{
			bounds(child,x,p);
		}

		// if(root.children.size() == 0)
		// 	return ;
	}

	public static node constructGT(Integer[] vals){

		node root = new node(vals[0]);

		Stack<node> st = new Stack<>();
		st.push(root);

		for(int i=1;i<vals.length;i++){
			if(vals[i] == null){
				st.pop();
			}else{

				// make a new node
				node newNode = new node(vals[i]);

				// make it children of the peek of the stack

				st.peek().children.add(newNode);
				st.push(newNode); 
			}
		}
		return root;
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
