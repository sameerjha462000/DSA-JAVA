	public static boolean find(node root,int x){
		if(root.data == x)
			return true;

		for(node child : root.children)
		{
			if(find(child,x))
				return true;
		}

		return false;
	}
