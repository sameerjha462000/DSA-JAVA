	public static int distanceBetweenNodes(node root,int x,int y){
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
		return (i+1) + (j+1); // i+1 is index of LCA in xNTRP and j+1 is index of LCA in yNTRP
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
		return new ArrayList<>();
	}
