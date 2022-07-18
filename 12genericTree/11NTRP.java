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
