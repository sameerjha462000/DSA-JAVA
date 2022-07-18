	public static int height(node root){

		if(root.children.size() == 0)
			return 0;

		int maxHeightTillChild = 0;

		for(node child : root.children)
		{
			maxHeightTillChild = (int)Math.max(maxHeightTillChild,height(child));
		}

		return maxHeightTillChild+1;
	}
