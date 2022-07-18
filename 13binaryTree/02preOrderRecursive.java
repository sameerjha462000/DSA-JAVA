  	void preOrderRecursive()
	{
		preOrderRecursiveHelper(root);
		System.out.println();
	}

	private void preOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;

		System.out.print(root.data + " ");
		preOrderRecursiveHelper(root.left);
		preOrderRecursiveHelper(root.right);
	}