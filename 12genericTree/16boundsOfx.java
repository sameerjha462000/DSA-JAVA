class pair{
	int first;
	int second;

	pair(int _first, int _second)
	{
		first = _first;
		second = _second;
	}

	@Override
	public String toString(){
		return "<"+first+", "+second+">";
	}
}

class Main{
	public static void main(String[] args) {
		initializeIO();
		Integer[] vals = {10,20,50,null,60,null,null,30,70,null,80,110,null,120,null,null,90,null,null,40,100,null,null,null};

		node root = constructGT(vals);
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		pair p = new pair(Integer.MIN_VALUE,Integer.MAX_VALUE);// p.first == floor and p.second == ceil
		bounds(root,x,p); // will give values just smaller and just greater than x (even if the value is present in the tree)
		System.out.println(p);
	}

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
