import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;

// added height function at 62
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
		Integer[] vals = {10,20,null,30,50,null,60,null,null,40,null,null};

		node root = constructGT(vals);
		System.out.println(root);
		System.out.println(size(root));
		System.out.println(max(root));
		System.out.println(height(root));
	}

	public static int max(node root){
		int max = root.data;
		for(node child : root.children)
		{
			max = (int)Math.max(max,max(child));
		}
		return max;
	}


	// height of a tree is defined as the no of edges from root node to the deepest node...
	// could also be defined as the number of nodes in between the root node and the deepest node...
	public static int height(node root){

		if(root.children.size() == 0)
			return 0;

		int maxHeightTillChild = 0;

		for(node child : root.children)
		{
			maxHeightTillChild = (int)Math.max(maxHeightTillChild,height(child));
		}

		return maxHeightTillChild+1;
	}

	public static int size(node root){
		int size = 1;
		for(node child : root.children){
			size += size(child);
		}
		return size;
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
