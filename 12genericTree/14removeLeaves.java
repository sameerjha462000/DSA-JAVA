import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;
import java.util.Queue;

// added remove leaves at 49...
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

class Main{
	public static void main(String[] args) {
		initializeIO();
		Integer[] vals = {10,20,50,null,60,null,null,30,70,null,80,110,
						  null,120,null,null,90,null,null,40,100,null,null,null};

		node root = constructGT(vals);
		removeLeaves(root);
	}

	public static void removeLeaves(node root)
	{
		int size = root.children.size()-1;

		for(int i=size;i>=0;--i)
		{
			node child = root.children.get(i);

			if(child.children.size() == 0)
			{
				root.children.remove(i);
			}
		}

		for(node child : root.children)
			removeLeaves(child);
		// base case
		if(root.children.size() == 0)
			return;
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
