import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;

// added KTH largest at 59...
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

class box{
	int data;

	box(int _data){
		data = _data;
	}
}

class Main{
	public static void main(String[] args) {
		initializeIO();
		Integer[] vals = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};

		node root = constructGT(vals);
		Scanner scn = new Scanner(System.in);

		int k = scn.nextInt();

		KTHlargest(root,k);
		
	}

	public static void KTHlargest(node root,int k){
		int ans = Integer.MAX_VALUE;
		
		for(int i=1;i<=k;i++){
			// find floor of ans in root
			box b = new box(Integer.MIN_VALUE);
			floor(root,ans,b);
			ans = b.data;

		}
		System.out.println(ans);
	}

	public static void floor(node root,int x,box b){
		if(root.data < x){
			if(root.data > b.data){
				b.data = root.data;
			}
		}

		for(node child : root.children)
		{
			floor(child,x,b);
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
