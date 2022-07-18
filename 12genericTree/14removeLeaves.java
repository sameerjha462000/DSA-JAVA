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
