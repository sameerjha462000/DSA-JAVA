	public static int lowestCommonAncestor(node root,int x,int y){
		ArrayList<Integer> xPath = nodeToRootPath(root,x);
		ArrayList<Integer> yPath = nodeToRootPath(root,y);

		int i = xPath.size()-1;
		int j = yPath.size()-1;

		while(i >= 0 && j >= 0){
			int valx = xPath.get(i);
			int valy = yPath.get(j);
			if(valx == valy)
			{
				i--;
				j--;
			}else{
				break;
			}
		}

		return xPath.get(i+1); // or yPath.get(j+1)
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
