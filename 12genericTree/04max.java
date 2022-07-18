	public static int max(node root){
		int max = root.data;
		for(node child : root.children)
		{
			max = (int)Math.max(max,max(child));
		}
		return max;
	}
