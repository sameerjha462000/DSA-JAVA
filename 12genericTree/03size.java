	public static int size(node root){
		int size = 1;
		for(node child : root.children){
			size += size(child);
		}
		return size;
	}
