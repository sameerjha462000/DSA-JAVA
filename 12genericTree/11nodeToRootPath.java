import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;
import java.util.Queue;

// added nodeToRootPath at 55...
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
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();

		ArrayList<Integer> NTRP = nodeToRootPath(root,x);

		System.out.println(NTRP);

	}

	public static ArrayList<Integer> nodeToRootPath(node root,int x){

		if(root.data == x)
		{
			ArrayList<Integer> base = new ArrayList<>();
			base.add(x);
			return base;
		}

		for(node child : root.children)
		{
			ArrayList<Integer> rres = nodeToRootPath(child,x);
			if(rres.size() != 0)
			{
				rres.add(root.data);
				return rres;
			}
		}

		return new ArrayList<Integer>();
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
