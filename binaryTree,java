import static java.lang.System.*;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Stack;
import java.util.Queue;

class node{
    int data;
    node left;
    node right;

    node() {}

    node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

class pair{
    node first;
    int second;

    pair(node first,int second)
    {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString()
    {
        return  "<" + first.data+", " + second+">";
    }
}

class BT{
    node root;
    static int ceilStorer = Integer.MAX_VALUE;
    static int floorStorer = Integer.MIN_VALUE;

    BT()
    {
        root = null;
    }

    BT(int[] nums)
    {
        Stack<pair> st = new Stack<>();
        root = new node(nums[0]);

        pair p = new pair(root,0);

        st.push(p);

        int idx = 1;
        while(idx < nums.length)
        {
            int state = st.peek().second;
            if(state == 2)
            {
                st.pop();
                continue;
            }

            if(nums[idx] == -1)
            {
                st.peek().second++;
                idx++;
                continue;
            }

            // Neither state is 2 nor value is -1

            node newNode = new node(nums[idx]);

            if(st.peek().second == 0)
            {
                st.peek().first.left = newNode;
            }else{
                st.peek().first.right = newNode;
            }

            st.peek().second++; // increase the state of node at the top of stack
            pair newPair = new pair(newNode,0); // create a new pair with newNode
            // with state 0
            st.push(newPair); // insert this new pair into the stack
            idx++; // change the index
        }
    }

    void toStringHelper(node root,StringBuilder sb)
    {
        if(root == null)
            return ;


        StringBuilder rres = new StringBuilder();

        rres.append("<-"+root.data+"->");
        if(root.left != null)
        {
            rres.insert(0,""+root.left.data);
        }

        if(root.right != null)
        {
            rres.append(""+root.right.data);
        }
        rres.append("\n");

        sb.append(rres.toString());


        // make calls to the left and right child
        toStringHelper(root.left,sb);
        toStringHelper(root.right,sb);
    }

    void levelOrder()
    {
        Queue<node> mq = new ArrayDeque<>();
        Queue<node> hq = new ArrayDeque<>();

        mq.add(root);

        while(!mq.isEmpty())
        {
            node removed = mq.peek();

            System.out.print(removed.data + " ");

            mq.remove();

            if(removed.left != null)
                hq.add(removed.left);
            if(removed.right != null)
                hq.add(removed.right);

            if(mq.isEmpty())
            {
                Queue<node> temp = mq;
                mq = hq;
                hq = temp;
            }
        }
    }


    void levelOrderLineWise()
    {
        Queue<node> mq = new ArrayDeque<>();
        Queue<node> hq = new ArrayDeque<>();

        mq.add(root);

        while(!mq.isEmpty())
        {
            node removed = mq.peek();

            System.out.print(removed.data+" ");

            mq.remove();

            if(removed.left != null)
                hq.add(removed.left);
            if(removed.right != null)
                hq.add(removed.right);

            if(mq.isEmpty())
            {
                Queue<node> temp = mq;
                mq = hq;
                hq = temp;

                System.out.println();
            }
        }
    }

    void levelOrderZigZag()
    {
        Stack<node> ms = new Stack<>();
        Stack<node> hs = new Stack<>();

        ms.push(root);

        int level = 0;

        while(!ms.isEmpty())
        {
            node removed = ms.pop();

            System.out.print(removed.data + " ");

            if(level % 2 == 0)
            {
                if(removed.left != null)
                    hs.push(removed.left);
                if(removed.right != null)
                    hs.push(removed.right);
            }else{
                if(removed.right != null)
                    hs.push(removed.right);
                if(removed.left != null)
                    hs.push(removed.left);
            }

            if(ms.isEmpty())
            {
                level++;
                Stack<node> temp = ms;
                ms = hs;
                hs = temp;
                System.out.println();
            }
        }
    }

    int size()
    {
        return sizeHelper(root);
    }

    int sizeHelper(node root)
    {
        if(root == null)
            return 0;
        return sizeHelper(root.left) + sizeHelper(root.right) + 1; 
    }

    int height()
    {
        return heightHelper(root);
    }

    int heightHelper(node root)
    {
        if(root == null)
            return -1;
        return (int)Math.max(heightHelper(root.left),heightHelper(root.right))+1;
    }

    int sum()
    {
        return sumHelper(root);
    }

    int sumHelper(node root)
    {
        if(root == null) return 0;

        return sumHelper(root.left)+sumHelper(root.right)+root.data;
    }

    int max()
    {
        return maxHelper(root);
    }

    int maxHelper(node root)
    {
        if(root == null)
        {
            return Integer.MIN_VALUE;
        }

        return (int)Math.max((int)Math.max(maxHelper(root.left),maxHelper(root.right)),root.data);
    }

    boolean find(int x)
    {
        return findHelper(root,x);
    }

    boolean findHelper(node root,int x)
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

    ArrayList<Integer> nodeToRootPath(int x)
    {
        return nodeToRootPathHelper(root,x);
    }

    ArrayList<Integer> nodeToRootPathHelper(node root,int x)
    {
        if(root.data == x)
        {
            ArrayList<Integer> base = new ArrayList<>();
            base.add(x);
            return base;
        }

        if(root.left != null)
        {
            ArrayList<Integer> rres = nodeToRootPathHelper(root.left,x);

            if(rres.size() > 0)
            {
                rres.add(root.data);
                return rres;
            }
        }

        if(root.right != null)
        {
            ArrayList<Integer> rres = nodeToRootPathHelper(root.right,x);

            if(rres.size() > 0)
            {
                rres.add(root.data);
                return rres;
            }
        }

        return new ArrayList<>();
    }

    int LCA(int x,int y)
    {
        ArrayList<Integer> xPath = nodeToRootPathHelper(root,x);
        ArrayList<Integer> yPath = nodeToRootPathHelper(root,y);

        // if anyone of them has zero size then no LCA
        int pro = xPath.size() * yPath.size();

        if(pro == 0)
        {
            System.out.println("NO LCA");
            return -1;
        }

        // pro is not zero
        int i = xPath.size()-1;
        int j = yPath.size()-1;

        while(i >=0 && j >= 0)
        {
            if(xPath.get(i) == yPath.get(j))
            {
                i--;
                j--;
            }else{
                break;
            }
        }

        return xPath.get(i+1); // yPath.get(j+1);
    }

    int distance(int x,int y)
    {
        ArrayList<Integer> xPath = nodeToRootPathHelper(root,x);

        if(xPath.size() == 0)
        {
            System.out.println(x+" is not present in the tree...");
            return -1;
        }

        ArrayList<Integer> yPath = nodeToRootPathHelper(root,y);

        if(yPath.size() == 0)
        {
            System.out.println(y + " is not present in the tree...");
            return -1;
        }

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
        j++;

        return i+j;
    }

    static void reset(){
        ceilStorer = Integer.MAX_VALUE;
        floorStorer = Integer.MIN_VALUE;
    }

    int ceil(int x)
    {
        // if(x >= maxHelper(root))
        // {
        //     System.out.println("Ceil does not exist");
        //     return -1;
        // }
        ceilHelper(root,x); // stores the value in ceilStorer
        int ans = ceilStorer;
        reset();
        return ans;
    }

    int floor(int x)
    {
        floorHelper(root,x);
        int ans = floorStorer;
        reset();
        return ans;
    }

    void floorHelper(node root,int x)
    {
        if(root.data < x)
        {
            if(root.data > floorStorer)
            {
                floorStorer = root.data;
            }
        }

        if(root.left != null)
            floorHelper(root.left,x);
        if(root.right != null)
            floorHelper(root.right,x);
    }

    void ceilHelper(node root,int x)
    {
        if(root.data > x)
        {
            if(root.data < ceilStorer)
            {
                ceilStorer = root.data;
            }
        }

        if(root.left != null)
            ceilHelper(root.left,x);
        if(root.right != null)
            ceilHelper(root.right,x);
    }

    int klargest(int k)
    {
        // assuming valid k has been passed

        int ans = Integer.MAX_VALUE;

        for(int i=0;i<k;i++){
            ans = floor(ans);
        }
        return ans;
    }

    int ksmallest(int k)
    {
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            ans = ceil(ans);
        }
        return ans;
    }

    ArrayList<Integer> klevelDown(int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();

        klevelDownHelper(root,k,ans);
        return ans;
    }

    void klevelDownHelper(node root,int k,ArrayList<Integer> ans)
    {
        if(root == null)
            return;

        if(k == 0)
        {
            ans.add(root.data);
            return;
        }

        klevelDownHelper(root.left,k-1,ans); // do not do k-- here
        klevelDownHelper(root.right,k-1,ans); // do not do k-- here
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        toStringHelper(root,sb);

        return sb.toString();
    }
}

class Main{
    public static void main(String[] args) {
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = scn.nextInt();
        }

        BT b = new BT(nums);
        // System.out.println(b);
        // b.levelOrder();
        // System.out.println();
        // b.levelOrderLineWise();

        // System.out.println();

        // b.levelOrderZigZag();
        // b.levelOrderLineWise();
        // System.out.println(b.size());
        // System.out.println(b.height());
        // System.out.println(b.sum());

        // for(int x=1;x<20;x++)
        //     System.out.println(b.find(x));

        // for(int x = 1;x <= 20;x++){
        //     ArrayList<Integer> pathTox = b.nodeToRootPath(x);
        //     System.out.println(pathTox);
        // }
        // System.out.println(b.LCA(10,13));
        // System.out.println(b.distance(11,12));
        // System.out.println(b.max());
        // for(int x=0;x<14;x++)
        // System.out.println(b.floor(x));
        // System.out.println(b.klargest(13));
        // System.out.println(b.ksmallest(5));
        System.out.println(b.klevelDown(2));

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
