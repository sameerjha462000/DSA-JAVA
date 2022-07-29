import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Stack;
import java.util.Queue;

	/**
	 * Author : @sam45jh
	 **/

	/**
         * Tree (By the way this is a Binary search tree now that i see this)
         * because its inorder is sorted already
         *         ___50
         * 	  /     \
         *       25     75
         *      / \    / \
         *     12 37  62  87
         * 	  /    \
         *       30    70
         * 
         * preorder : root left right -- 50 25 12 37 30 75 62 70 87
         * inorder : left root right -- 12 25 30 37 50 62 70 75 87
         * postorder : left right root -- 12 30 37 25 70 62 87 75 50
         **/
public class Main{
	
    public static void main(String[] hi) throws IOException{
        initializeIO();    
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));     
        int n = Integer.parseInt(br.readLine());

        Integer[] nums = new Integer[n];

        String[] values = br.readLine().split(" ");

        for(int i=0;i<n;i++)
        {
        	String str = values[i];
        	if(str.equals("n") == false)
        	{
        		nums[i] = Integer.parseInt(values[i]);
        	}else{
        		nums[i] = null;
        	}
        }

        BT b = new BT(nums);

        
        System.out.println(b);

    }
	
    private static void initializeIO(){
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}

class node{
	int data;
	node left;
	node right;

	node(){}
	node(int data)
	{
		this.data = data;
	}
	node(int data,node left,node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class pair{
	node first;
	int state;

	pair(node first,int state)
	{
		this.first = first;
		this.state = state;
	}
	
	@Override
	public String toString()
	{
		return "<"+first.data+", "+state+">";
	}
}

class BT{
	private node root;
	BT(Integer[] nums)
	{
		Stack<pair> st = new Stack<>();
		root = new node(nums[0]);
		st.push(new pair(root,0));

		int idx = 1;
		while(idx < nums.length)
		{
			pair top = st.peek();
			if(top.state == 2)
			{
				st.pop();
				continue;
			}

			if(nums[idx] == null)
			{
				top.state++;
				idx++;
				continue;
			}

			// Now the nums[idx] is not null and also state is not 2
			node newNode = new node(nums[idx]);
			if(top.state == 0)
			{
				top.first.left = newNode;
			}else{
				top.first.right = newNode;
			}

			top.state++;
			st.push(new pair(newNode,0));
			idx++;
		}
	}

	BT(int[] nums)
	{
		Stack<pair> st = new Stack<>();

		root = new node(nums[0]);

		st.push(new pair(root,0));

		int idx = 1;
		while(idx < nums.length)
		{
			pair top = st.peek();

			if(top.state == 2)
			{
				st.pop();
				continue;
			}

			if(nums[idx] == -1)
			{
				top.state++;
				idx++;
				continue;
			}

			// Now neither the state is 2 nor the nums[idx] is -1
			node newNode = new node(nums[idx]);

			if(top.state == 0)
			{
				top.first.left = newNode;
			}else{
				top.first.right = newNode;
			}

			top.state++;
			st.push(new pair(newNode,0));
			idx++;
		}
	}

	void preOrderRecursive()
	{
		preOrderRecursiveHelper(root);
		System.out.println();
	}

	private void preOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;

		System.out.print(root.data + " ");
		preOrderRecursiveHelper(root.left);
		preOrderRecursiveHelper(root.right);
	}

	void postOrderRecursive()
	{
		postOrderRecursiveHelper(root);
		System.out.println();
	}

	private void postOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;

		postOrderRecursiveHelper(root.left);
		postOrderRecursiveHelper(root.right);
		System.out.print(root.data + " ");
	}

	void inOrderRecursive()
	{
		inOrderRecursiveHelper(root);
		System.out.println();
	}

	private void inOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;
		inOrderRecursiveHelper(root.left);
		System.out.print(root.data + " ");
		inOrderRecursiveHelper(root.right);
	}

	void preOrderIterative()
    	{
          Stack<node> st = new Stack<>();

          st.push(root);

          while(!st.isEmpty())
          {
                node top = st.pop();
                System.out.print(top.data + " ");

                if(top.right != null)
                {
                  st.push(top.right);
                }

                if(top.left != null)
                {
                  st.push(top.left);
                }
          }
    	}

    	void postOrderIterative()
	{
		Stack<node> mainStack = new Stack<>();
		Stack<node> helperStack = new Stack<>();

		mainStack.push(root);

		while(!mainStack.isEmpty())
		{
			node removed = mainStack.pop();

			helperStack.push(removed);

			if(removed.left != null)
			{
				mainStack.push(removed.left);
			}

			if(removed.right != null)
			{
				mainStack.push(removed.right);
			}
		}

		while(!helperStack.isEmpty())
		{
			System.out.print(helperStack.pop().data+ " ");
		}
	}

	void inOrderIterative()
    	{
          Stack<node> st = new Stack<>();
          st.push(root);

          while(st.peek().left != null)
          {
            st.push(st.peek().left);
          }
        
          while(!st.isEmpty())
          {
                while(st.peek().right == null)
                {
                  node top = st.pop();
                  System.out.print(top.data + " ");
                }

                if(!st.isEmpty())
                {
                      node topAgain = st.pop();
                      System.out.print(topAgain.data + " ");
                      st.push(topAgain.right);

                      while(st.peek().left != null)
                      {
                        st.push(st.peek().left);
                      }
                }
          }
    	}

	private void toStringHelper(node root,StringBuilder ans)
	{
		if(root == null)
			return;
		StringBuilder help = new StringBuilder();

		if(root.left != null)
			help.append(""+root.left.data);

		help.append("<-"+root.data+"->");

		if(root.right != null)
		{
			help.append(""+root.right.data);
		}
		help.append("\n");

		ans.append(help);

		toStringHelper(root.left,ans);
		toStringHelper(root.right,ans);
	}
	
	void levelOrder()
    	{
		Queue<node> mainQ = new ArrayDeque<node>();
		Queue<node> helperQ = new ArrayDeque<node>();

		mainQ.add(root);

		while(!mainQ.isEmpty())
			{
				node removed = mainQ.remove();

				System.out.print(removed.data + " ");

				if(removed.left != null)
					helperQ.add(removed.left);

				if(removed.right != null)
				{
					helperQ.add(removed.right);
				}

				if(mainQ.isEmpty())
				{
					// System.out.println();
					Queue<node> temp = mainQ;
					mainQ = helperQ;
					helperQ = temp;
					System.out.println();
				}
			}
    	}

	    int size()
	    {
		return sizeHelper(root);
	    }

	    private int sizeHelper(node root)
	    {
		if(root == null)
			return 0;

		return sizeHelper(root.left)+sizeHelper(root.right)+1;
	    }

	    int sum()
	    {
		return sumHelper(root);
	    }

	    private int sumHelper(node root)
	    {
		if(root == null)
			return 0;

		return sumHelper(root.left)+sumHelper(root.right)+root.data;
	    }

	    int height()
	    {
		return heightHelper(root);
	    }

	    private int heightHelper(node root)
	    {
		if(root == null)
			return -1;

		return Math.max(heightHelper(root.left),heightHelper(root.right))+1;
	    }

	    int max()
	    {
		return maxHelper(root);
	    }

	    private int maxHelper(node root)
	    {
		if(root == null)
			return Integer.MIN_VALUE;

		return (int)Math.max((int)Math.max(maxHelper(root.left),maxHelper(root.right)),root.data);
	    }

	private void toStringHelper(node root,StringBuilder ans)
	{
		if(root == null)
			return;
		StringBuilder help = new StringBuilder();

		if(root.left != null)
			help.append(""+root.left.data);

		help.append("<-"+root.data+"->");

		if(root.right != null)
		{
			help.append(""+root.right.data);
		}
		help.append("\n");

		ans.append(help);

		toStringHelper(root.left,ans);
		toStringHelper(root.right,ans);
	}

	boolean find(int x)
	{
		return findHelper(root,x);
	}

	private boolean findHelper(node root,int x)
	{
		if(root.data == x)
			return true;

		if(root.left != null)
		{
			if(findHelper(root.left,x))
				return true;
		}

		if(root.right != null)
		{
			if(findHelper(root.right,x))
				return true;
		}

		return false;
	}

	ArrayList<Integer> NTRP(int x)
	{
		return NTRPHelper(root,x);
	}

	ArrayList<Integer> NTRPHelper(node root,int x)
	{
		if(root == null)
			return new ArrayList<>();
		if(root.data == x)
		{
			ArrayList<Integer> base = new ArrayList<>();

			base.add(x);
			return base;
		}

		ArrayList<Integer> rresLeft = NTRPHelper(root.left,x);

		if(rresLeft.size() > 0)
		{
			rresLeft.add(root.data);
			return rresLeft;
		}	

		ArrayList<Integer> rresTwo = NTRPHelper(root.right,x);

		if(rresTwo.size() > 0)
		{
			rresTwo.add(root.data);
			return rresTwo;
		}

		return new ArrayList<>();

	}
	
	List<Integer> kLevelDown(int k)
	{
		List<Integer> ans = new ArrayList<>();
		kLevelDownHelper(root,k,ans);
		return ans;
	}

	private void kLevelDownHelper(node root,int k,List<Integer> ans)
	{
		if(root == null)
			return ;
		if(k == 0)
		{
			ans.add(root.data);
			return;
		}

		kLevelDownHelper(root.left,k-1,ans);
		kLevelDownHelper(root.right,k-1,ans);
	}

	List<Integer> leafNodes()
	{
		List<Integer> ans = new ArrayList<>();

		leafNodesHelper(root,ans);

		return ans;
	}

	void leafNodesHelper(node root,List<Integer> ans)
	{
		if(root == null)
			return ;

		if(root.left == null && root.right == null)
		{
			ans.add(root.data);
		}

		leafNodesHelper(root.left,ans);
		leafNodesHelper(root.right,ans);

	}

	void removeLeafNodes()
	{
		removeLeafNodesHelper(root);
	}

	void removeLeafNodesHelper(node root)
	{
		if(root == null)
			return;

		if(root.left != null)
		{
			// do something
			if(root.left.left == null && root.left.right == null)
			{
				root.left = null;
			}
		}

		if(root.right != null)
		{
			// do something...

			if(root.right.left == null && root.right.right == null)
			{
				root.right = null;
			}
		}

		removeLeafNodesHelper(root.left);
		removeLeafNodesHelper(root.right);
	}
	int diameter()
	{
		int[] ans = new int[1];
		diameterHelper(root,ans);
		return ans[0];
	}

	int diameterHelper(node root,int[] ans)
	{
		if(root == null)
			return -1;

		int ht = -1;

		int htOne = diameterHelper(root.left,ans);
		int htTwo = diameterHelper(root.right,ans);

		ht = (int)Math.max(htOne,htTwo)+1;

		int diameterThroughtRoot = htOne + htTwo + 2;

		if(diameterThroughtRoot > ans[0])
		{
			ans[0] = diameterThroughtRoot;
		}

		return ht;
	}
	
	List<Integer> singleChild()
	{
		List<Integer> ans = new ArrayList<>();

		singleChildHelper(root,ans);

		return ans;
	}

	void singleChildHelper(node root,List<Integer> ans)
	{
		if(root == null)
			return ;

		if(root.left != null && root.right == null)
		{
			ans.add(root.left.data);
		}

		if(root.left == null && root.right != null)
		{
			ans.add(root.right.data);
		}

		singleChildHelper(root.left,ans);
		singleChildHelper(root.right,ans);
	}
	
	import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Stack;
import java.util.Queue;

		/**
		 * Author : @sam45jh
		 **/

		/**
         * Tree (By the way this is a Binary search tree now that i see this)
         * because its inorder is sorted already
         * 		   ___50
         * 	      /     \
         *       25     75
         *      / \    / \
         *     12 37  62  87
         * 	      /    \
         *       30    70
         * 
         * preorder : root left right -- 50 25 12 37 30 75 62 70 87
         * inorder : left root right -- 12 25 30 37 50 62 70 75 87
         * postorder : left right root -- 12 30 37 25 70 62 87 75 50
         **/
public class MainAgain{
    public static void main(String[] hi) throws IOException{
        initializeIO();    
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));     
        int n = Integer.parseInt(br.readLine());

        Integer[] nums = new Integer[n];

        String[] values = br.readLine().split(" ");

        for(int i=0;i<n;i++)
        {
        	String str = values[i];
        	if(str.equals("n") == false)
        	{
        		nums[i] = Integer.parseInt(values[i]);
        	}else{
        		nums[i] = null;
        	}
        }

        BT b = new BT(nums);

    }
    private static void initializeIO(){
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}

class node{
	int data;
	node left;
	node right;

	node(){}
	node(int data)
	{
		this.data = data;
	}
	node(int data,node left,node right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class pair{
	node first;
	int state;

	pair(node first,int state)
	{
		this.first = first;
		this.state = state;
	}
	@Override
	public String toString()
	{
		return "<"+first.data+", "+state+">";
	}
}

class BT{
	private node root;
	BT(Integer[] nums)
	{
		Stack<pair> st = new Stack<>();
		root = new node(nums[0]);
		st.push(new pair(root,0));

		int idx = 1;
		while(idx < nums.length)
		{
			pair top = st.peek();
			if(top.state == 2)
			{
				st.pop();
				continue;
			}

			if(nums[idx] == null)
			{
				top.state++;
				idx++;
				continue;
			}

			// Now the nums[idx] is not null and also state is not 2
			node newNode = new node(nums[idx]);
			if(top.state == 0)
			{
				top.first.left = newNode;
			}else{
				top.first.right = newNode;
			}

			top.state++;
			st.push(new pair(newNode,0));
			idx++;
		}
	}

	BT(int[] nums)
	{
		Stack<pair> st = new Stack<>();

		root = new node(nums[0]);

		st.push(new pair(root,0));

		int idx = 1;
		while(idx < nums.length)
		{
			pair top = st.peek();

			if(top.state == 2)
			{
				st.pop();
				continue;
			}

			if(nums[idx] == -1)
			{
				top.state++;
				idx++;
				continue;
			}

			// Now neither the state is 2 nor the nums[idx] is -1
			node newNode = new node(nums[idx]);

			if(top.state == 0)
			{
				top.first.left = newNode;
			}else{
				top.first.right = newNode;
			}

			top.state++;
			st.push(new pair(newNode,0));
			idx++;
		}
	}

	void preOrderRecursive()
	{
		preOrderRecursiveHelper(root);
		System.out.println();
	}

	private void preOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;

		System.out.print(root.data + " ");
		preOrderRecursiveHelper(root.left);
		preOrderRecursiveHelper(root.right);
	}

	void postOrderRecursive()
	{
		postOrderRecursiveHelper(root);
		System.out.println();
	}

	private void postOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;

		postOrderRecursiveHelper(root.left);
		postOrderRecursiveHelper(root.right);
		System.out.print(root.data + " ");
	}

	void inOrderRecursive()
	{
		inOrderRecursiveHelper(root);
		System.out.println();
	}

	private void inOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;
		inOrderRecursiveHelper(root.left);
		System.out.print(root.data + " ");
		inOrderRecursiveHelper(root.right);
	}

	void preOrderIterative()
    {
          Stack<node> st = new Stack<>();

          st.push(root);

          while(!st.isEmpty())
          {
                node top = st.pop();
                System.out.print(top.data + " ");

                if(top.right != null)
                {
                  st.push(top.right);
                }

                if(top.left != null)
                {
                  st.push(top.left);
                }
          }
    }

    void postOrderIterative()
	{
		Stack<node> mainStack = new Stack<>();
		Stack<node> helperStack = new Stack<>();

		mainStack.push(root);

		while(!mainStack.isEmpty())
		{
			node removed = mainStack.pop();

			helperStack.push(removed);

			if(removed.left != null)
			{
				mainStack.push(removed.left);
			}

			if(removed.right != null)
			{
				mainStack.push(removed.right);
			}
		}

		while(!helperStack.isEmpty())
		{
			System.out.print(helperStack.pop().data+ " ");
		}
	}

	void inOrderIterative()
    {
          Stack<node> st = new Stack<>();
          st.push(root);

          while(st.peek().left != null)
          {
            st.push(st.peek().left);
          }
        
          while(!st.isEmpty())
          {
                while(st.peek().right == null)
                {
                  node top = st.pop();
                  System.out.print(top.data + " ");
                }

                if(!st.isEmpty())
                {
                      node topAgain = st.pop();
                      System.out.print(topAgain.data + " ");
                      st.push(topAgain.right);

                      while(st.peek().left != null)
                      {
                        st.push(st.peek().left);
                      }
                }
          }
    }

    void levelOrder()
    {
    	Queue<node> mainQ = new ArrayDeque<node>();
    	Queue<node> helperQ = new ArrayDeque<node>();

    	mainQ.add(root);

    	while(!mainQ.isEmpty())
    	{
    		node removed = mainQ.remove();

    		System.out.print(removed.data + " ");

    		if(removed.left != null)
    			helperQ.add(removed.left);

    		if(removed.right != null)
    		{
    			helperQ.add(removed.right);
    		}

    		if(mainQ.isEmpty())
    		{
    			// System.out.println();
    			Queue<node> temp = mainQ;
    			mainQ = helperQ;
    			helperQ = temp;
    			System.out.println();
    		}
    	}
    }

    int size()
    {
    	return sizeHelper(root);
    }

    private int sizeHelper(node root)
    {
    	if(root == null)
    		return 0;

    	return sizeHelper(root.left)+sizeHelper(root.right)+1;
    }

    int sum()
    {
    	return sumHelper(root);
    }

    private int sumHelper(node root)
    {
    	if(root == null)
    		return 0;

    	return sumHelper(root.left)+sumHelper(root.right)+root.data;
    }

    int height()
    {
    	return heightHelper(root);
    }

    private int heightHelper(node root)
    {
    	if(root == null)
    		return -1;

    	return Math.max(heightHelper(root.left),heightHelper(root.right))+1;
    }

    int max()
    {
    	return maxHelper(root);
    }

    private int maxHelper(node root)
    {
    	if(root == null)
    		return Integer.MIN_VALUE;

    	return (int)Math.max((int)Math.max(maxHelper(root.left),maxHelper(root.right)),root.data);
    }

	private void toStringHelper(node root,StringBuilder ans)
	{
		if(root == null)
			return;
		StringBuilder help = new StringBuilder();

		if(root.left != null)
			help.append(""+root.left.data);

		help.append("<-"+root.data+"->");

		if(root.right != null)
		{
			help.append(""+root.right.data);
		}
		help.append("\n");

		ans.append(help);

		toStringHelper(root.left,ans);
		toStringHelper(root.right,ans);
	}

	boolean find(int x)
	{
		return findHelper(root,x);
	}

	private boolean findHelper(node root,int x)
	{
		if(root.data == x)
			return true;

		if(root.left != null)
		{
			if(findHelper(root.left,x))
				return true;
		}

		if(root.right != null)
		{
			if(findHelper(root.right,x))
				return true;
		}

		return false;
	}

	ArrayList<Integer> NTRP(int x)
	{
		return NTRPHelper(root,x);
	}

	ArrayList<Integer> NTRPHelper(node root,int x)
	{
		if(root == null)
			return new ArrayList<>();
		if(root.data == x)
		{
			ArrayList<Integer> base = new ArrayList<>();

			base.add(x);
			return base;
		}

		ArrayList<Integer> rresLeft = NTRPHelper(root.left,x);

		if(rresLeft.size() > 0)
		{
			rresLeft.add(root.data);
			return rresLeft;
		}	

		ArrayList<Integer> rresTwo = NTRPHelper(root.right,x);

		if(rresTwo.size() > 0)
		{
			rresTwo.add(root.data);
			return rresTwo;
		}

		return new ArrayList<>();

	}

	List<Integer> kLevelDown(int k)
	{
		List<Integer> ans = new ArrayList<>();
		kLevelDownHelper(root,k,ans);
		return ans;
	}

	private void kLevelDownHelper(node root,int k,List<Integer> ans)
	{
		if(root == null)
			return ;
		if(k == 0)
		{
			ans.add(root.data);
			return;
		}

		kLevelDownHelper(root.left,k-1,ans);
		kLevelDownHelper(root.right,k-1,ans);
	}

	List<Integer> leafNodes()
	{
		List<Integer> ans = new ArrayList<>();

		leafNodesHelper(root,ans);

		return ans;
	}

	void leafNodesHelper(node root,List<Integer> ans)
	{
		if(root == null)
			return ;

		if(root.left == null && root.right == null)
		{
			ans.add(root.data);
		}

		leafNodesHelper(root.left,ans);
		leafNodesHelper(root.right,ans);

	}

	void removeLeafNodes()
	{
		removeLeafNodesHelper(root);
	}

	void removeLeafNodesHelper(node root)
	{
		if(root == null)
			return;

		if(root.left != null)
		{
			// do something
			if(root.left.left == null && root.left.right == null)
			{
				root.left = null;
			}
		}

		if(root.right != null)
		{
			// do something...

			if(root.right.left == null && root.right.right == null)
			{
				root.right = null;
			}
		}

		removeLeafNodesHelper(root.left);
		removeLeafNodesHelper(root.right);
	}

	int diameter()
	{
		int[] ans = new int[1];
		diameterHelper(root,ans);
		return ans[0];
	}

	int diameterHelper(node root,int[] ans)
	{
		if(root == null)
			return -1;

		int ht = -1;

		int htOne = diameterHelper(root.left,ans);
		int htTwo = diameterHelper(root.right,ans);

		ht = (int)Math.max(htOne,htTwo)+1;

		int diameterThroughtRoot = htOne + htTwo + 2;

		if(diameterThroughtRoot > ans[0])
		{
			ans[0] = diameterThroughtRoot;
		}

		return ht;
	}

	List<Integer> singleChild()
	{
		List<Integer> ans = new ArrayList<>();

		singleChildHelper(root,ans);

		return ans;
	}

	void singleChildHelper(node root,List<Integer> ans)
	{
		if(root == null)
			return ;

		if(root.left != null && root.right == null)
		{
			ans.add(root.left.data);
		}

		if(root.left == null && root.right != null)
		{
			ans.add(root.right.data);
		}

		singleChildHelper(root.left,ans);
		singleChildHelper(root.right,ans);
	}

	int tilt()
	{
		int[] ans = new int[1];

		tiltHelper(root,ans);

		return ans[0];
	}

	int tiltHelper(node root,int[] ans)
	{
		if(root == null)
			return 0;

		int sumOne = tiltHelper(root.left,ans);
		int sumTwo = tiltHelper(root.right,ans);

		ans[0] += (int)Math.abs(sumOne - sumTwo);
		return sumOne + sumTwo + root.data;
	}
	
	int LCA(int x,int y)
	{
		/** Assuming that x and y are present in the tree
		 **/

		List<Integer> xNTRP = NTRP(x);
		List<Integer> yNTRP = NTRP(y);

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

		/* LCA would be present at i+1 index of NTRP or j+1 index of yNTRP */

		return xNTRP.get(i+1); // yNTRP.get(j)
	}
	
	int distance(int x,int y)
	{
		List<Integer> xPath = NTRP(x);
		List<Integer> yPath = NTRP(y);

		int i = xPath.size()-1;
		int j = yPath.size()-1;

		while(i >= 0 && j >= 0)
		{
			if(xPath.get(i) == yPath.get(j))
			{
				i--;
				j--;
			}else{
				break;
			}
		}

		/**
		 * The distance between them is the number of edges in the path from x to y through LCA
		 * So the distance is sum of indices of LCA in xPath and yPath.
		 **/

		i++;
		j++;
		return i+j;
	}

	List<Integer> path(int x, int y)
	{
		List<Integer> xPath = NTRP(x);
		List<Integer> yPath = NTRP(y);

		List<Integer> path = new ArrayList<>();

		int i = xPath.size()-1;
		int j = yPath.size()-1;

		while(i >= 0 && j >= 0)
		{
			if(xPath.get(i) == yPath.get(j))
			{
				i--;
				j--;
			}else{
				break;
			}
		}

		i++;
		// j++;

		int idx = 0;

		while(idx <= i)
		{
			path.add(xPath.get(idx));
			idx++;
		}

		while(j >= 0)
		{
			path.add(yPath.get(j));
			j--;
		}

		return path;
	}
	
	boolean similarInShape(BT other)
	{
		return similarInShapeHelper(root,other.root);
	}

	boolean similarInShapeHelper(node rootOne, node rootTwo)
	{
		if(rootOne == null && rootTwo != null)
		{
			return false;
		}

		if(rootOne != null && rootTwo == null)
		{
			return false;
		}

		if(rootOne == null && rootTwo == null)
		{
			return false;
		}

		// Now rootOne != null and rootTwo is not null
		int scoreOfOne = 0;
		int scoreOfTwo = 0;

		if(rootOne.left != null)
			scoreOfOne++;
		if(rootOne.right != null)
			scoreOfOne++;

		if(rootTwo.left != null)
			scoreOfTwo++;
		if(rootTwo.right != null)
			scoreOfTwo++;

		if((scoreOfOne == 2 && scoreOfTwo == 2)||(scoreOfOne == 0 && scoreOfTwo == 0))
		{
			return true;
		}

		// Now scoreOfOne is 1 and ScoreOfTwo is also 1

		if(rootOne.left != null && rootTwo.left != null)
		{
			return similarInShapeHelper(rootOne.left,rootTwo.left);
		}
		if(rootOne.right != null && rootTwo.right != null)
		{
			return similarInShapeHelper(rootOne.right,rootTwo.left);
		}

		return false;
	}
	
	@Override
	public String toString()
	{
		StringBuilder ans = new StringBuilder();
		toStringHelper(root,ans);
		return ans.toString();
	}
}
