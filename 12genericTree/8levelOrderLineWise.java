import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;
import java.util.Queue;

// added levelOrderLineWise at 49...
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
		// System.out.println(root)
		levelOrderLineWise(root); // there are 4 approaches of this method...
	}

	public static void levelOrderLineWise(node root){
		Queue<node> curr = new ArrayDeque<>();
		Queue<node> next = new ArrayDeque<>();
		levelOrderLineWiseHelper(root,curr,next);
	}

	public static void levelOrderLineWiseHelper(node root,Queue<node> curr,Queue<node> next){
		curr.add(root);

		while(!curr.isEmpty()){
			node removed = curr.remove();
			for(node child : removed.children)
			{
				next.add(child);
			}
			System.out.print(removed.data+" ");
			if(curr.isEmpty()){
				// swap curr and next
				Queue<node> temp = curr;
				curr = next;
				next = temp;

				// since curr is empty so print next line
				System.out.println();
			}
		}
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
