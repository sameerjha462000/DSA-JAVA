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

	@Override
	public String toString()
	{
		StringBuilder ans = new StringBuilder();
		toStringHelper(root,ans);
		return ans.toString();
	}
}
