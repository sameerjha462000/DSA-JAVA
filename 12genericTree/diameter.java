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


class Main{
	public static void main(String[] args) {
		initializeIO();
		Integer[] vals = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};

		node root = constructGT(vals);
		diameter(root);
		System.out.println(diameter);
		
	}

	static int diameter = Integer.MIN_VALUE;
	public static void diameter(node root){
		diameter = (int)Math.max(diameter,diameterThruNode(root));

		for(node child : root.children)
		{
			diameter(child);
		}
	}

	public static int diameterThruNode(node root){
		int lh = -1;
		int slh = -1;

		if(root.children.size() == 0)
		{
			return lh+slh+2;
		}

		if(root.children.size() == 1)
		{
			lh = height(root.children.get(0));
			return lh+slh+2;
		}

		ArrayList<Integer> heights = new ArrayList<>();

		for(node child : root.children)
		{
			heights.add(height(child));
		}
		Collections.sort(heights);
		lh = heights.get(heights.size()-1);
		slh = heights.get(heights.size()-2);
		return lh+slh+2;
	}

	public static int height(node root){
		int ht = -1;

		for(node child : root.children)
		{
			ht = (int)Math.max(ht,height(child));
		}
		return ht+1;
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
