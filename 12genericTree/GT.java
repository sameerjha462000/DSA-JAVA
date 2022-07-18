import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;

class node{
	int data;
	ArrayList<node> children;

	node(int val)
	{
		data = val;
		children = new ArrayList<>();
	}

	@Override
	public String toString()
	{
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

	pair(int first, int second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString()
	{
		return "<"+first+", "+second+">";
	}
}

class box{
	int data;

	box(int data)
	{
		this.data = data;
	}
}

class Main{
	public static void main(String[] args) 
	{
		initializeIO();
		Integer[] vals = {10,20,null,30,50,null,60,null,null,40,null,null};

		node root = constructGT(vals);

	}

	public static node constructGT(Integer[] vals)
	{

		node root = new node(vals[0]);

		Stack<node> st = new Stack<>();
		st.push(root);

		for(int i=1;i<vals.length;i++)
		{
			if(vals[i] == null)
			{
				st.pop();
			}
			else
			{
				node newNode = new node(vals[i]);
				st.peek().children.add(newNode);
				st.push(newNode); 
			}
		}
		return root;
	}

	public static int size(node root)
	{
		int size = 1;
		for(node child : root.children)
		{
			size += size(child);
		}
		return size;
	}

	public static int max(node root)
	{
		int max = root.data;
		for(node child : root.children)
		{
			max = (int)Math.max(max,max(child));
		}
		return max;
	}

	public static int height(node root)
	{

		if(root.children.size() == 0)
			return 0;

		int maxHeightTillChild = 0;

		for(node child : root.children)
		{
			maxHeightTillChild = (int)Math.max(maxHeightTillChild,height(child));
		}

		return maxHeightTillChild+1;
	}

	public static void traversals(node root)
	{

		// node pre means node pr aakr sbse pehla kaam
		System.out.println("node pre " + root.data);

		for(node child : root.children)
		{

			// edge pre means node pr call lgne se pehle wala kaam
			System.out.println("edge pre " + root.data + "--" + child.data);

			traversals(child);

			// edge post means node pr call over hone ke baad wala kaam
			System.out.println("edge post " + root.data + "--" + child.data);
		}

		// node post means node pr call over hone se pehle last kaam
		System.out.println("node post " + root.data);
  	}

  	public static void levelOrder(node root)
  	{
		/**
		 * In normal traversals we use stack but if we want to access elements levelwise
		 * then we use queue.
		 **/
		Queue<node> queue = new ArrayDeque<>();

		queue.add(root);

		while(!queue.isEmpty())
		{
			node removed = queue.remove();

			for(node child : removed.children)
				queue.add(child);

			System.out.print(removed.data+" ");
		}
	}

	public static void levelOrderLineWise(node root)
	{
		Queue<node> curr = new ArrayDeque<>();
		Queue<node> next = new ArrayDeque<>();
		levelOrderLineWiseHelper(root,curr,next);
	}

	private static void levelOrderLineWiseHelper(node root,Queue<node> curr,Queue<node> next)
	{
		curr.add(root);

		while(!curr.isEmpty())
		{
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

	public static void levelOrderLineWiseZigZag(node root)
	{
		Stack<node> curr = new Stack<>();
		Stack<node> next = new Stack<>();

		levelOrderLineWiseZigZagHelper(root,curr,next);
	}

	private static void levelOrderLineWiseZigZagHelper(node root,Stack<node> curr,Stack<node> next)
	{
		curr.push(root);
		int level = 0;

		while(!curr.isEmpty())
		{
			node removed = curr.pop();

			if(level % 2 == 0)
			{
				for(node child : removed.children)
					next.push(child);
			}else{
				for(int i=removed.children.size()-1;i>=0;i--)
				{
					next.push(removed.children.get(i));
				}
			}

			System.out.print(removed.data+" ");

			if(curr.isEmpty())
			{
				Stack<node> temp = curr;
				curr = next;
				next = temp;
				System.out.println();
				level++;
			}
		}
	}

	public static boolean find(node root,int x)
	{
		if(root.data == x)
			return true;

		for(node child : root.children)
		{
			if(find(child,x))
				return true;
		}

		return false;
	}

	public static ArrayList<Integer> nodeToRootPath(node root,int x)
	{

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

	public static int lowestCommonAncestor(node root,int x,int y)
	{
		ArrayList<Integer> xPath = nodeToRootPath(root,x);
		ArrayList<Integer> yPath = nodeToRootPath(root,y);

		int i = xPath.size()-1;
		int j = yPath.size()-1;

		while(i >= 0 && j >= 0)
		{
			int valx = xPath.get(i);
			int valy = yPath.get(j);
			if(valx == valy)
			{
				i--;
				j--;
			}
			else
			{
				break;
			}
		}

		return xPath.get(i+1); // or yPath.get(j+1)
	}

	/**
	 * 	public static int heightAgain(node root)
	 *	{
	 *		int ht = -1;
	 *		for(node child : root.children)
	 *			ht = (int)Math.max(ht,heightAgain(child));
	 *		return ht+1;
	 *	}
	 **/

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

	public static int distanceBetweenNodes(node root,int x,int y)
	{
		ArrayList<Integer> xNTRP = nodeToRootPath(root,x);
		ArrayList<Integer> yNTRP = nodeToRootPath(root,y);

		int i = xNTRP.size()-1;
		int j = yNTRP.size()-1;

		while(i >= 0 && j >= 0)
		{
			if(xNTRP.get(i) == yNTRP.get(j))
			{
				i--;
				j--;
			}else{
				break;
			}
		}
		/**
		 * `i+1` is the index of LCA in the arraylist xNTRP and `j+1` is the index of LCA in yNTRP
		 **/
		return (i+1) + (j+1);
	}

	/**
	 * @param -- In bounds the pair `p` stores the floor and ceil of `x` in the tree rooted at `root`
	 * 
	 * Before calling bounds pass a pair along with root and x initialized as follows
	 * 
	 * pair p =  new pair(Integer.MIN_VALUE,Integer.MAX_VALUE)
	 **/
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

	public static void KTHlargest(node root,int k){
		int ans = Integer.MAX_VALUE;
		
		for(int i=1;i<=k;i++)
		{
			// find floor of ans in root
			box b = new box(Integer.MIN_VALUE);
			floor(root,ans,b);
			ans = b.data;

		}
		System.out.println(ans);
	}

	public static void floor(node root,int x,box b)
	{
		if(root.data < x)
		{
			if(root.data > b.data)
			{
				b.data = root.data;
			}
		}

		for(node child : root.children)
		{
			floor(child,x,b);
		}
	}

	/**
	 * static variable ans stores the diameter of the tree, so for getting diameter
	 * just print the ans.
	 **/

	static int ans = Integer.MIN_VALUE;
	public static int diameter(node root)
	{
		int lh = -1;
		int slh = -1;

		for(node child : root.children)
		{
			int cht = diameter(child);
			
			if(cht > lh)
			{
				slh = lh;
				lh = cht;
			}else if(cht > slh)
			{
				slh = cht;
			}else{
				// do nothing
			}
		}

		int dia = lh + slh + 2;
		ans = Math.max(ans,dia);
		return lh+1;

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
