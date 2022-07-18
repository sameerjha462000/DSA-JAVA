	public static int height(node root)
	{
		int ht = -1;
		for(node child : root.children)
			ht = (int)Math.max(ht,height(child));
		return ht+1;
	}
