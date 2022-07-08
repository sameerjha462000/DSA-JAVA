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
		System.out.println(ans);
		
	}

	static int ans = Integer.MIN_VALUE;
	public static int diameter(node root)
	{
		int lh = -1;
		int slh = -1;

		for(node child : root.children)
		{
			int cht = diameter(child);
			
			if(cht > lh){
				slh = lh;
				lh = cht;
			}else if(cht > slh){
				slh = cht;
			}else{
				// do nothing
			}
		}

		int dia = lh + slh + 2;
		ans = Math.max(ans,dia);
		return lh+1;
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
