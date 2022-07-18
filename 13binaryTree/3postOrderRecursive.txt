  	void postOrderRecursive()
	{
		postOrderRecursiveHelper(root);
		System.out.println();
	}

	private void postOrderRecursiveHelper(node root)
	{
		if(root == null)
			return ;

		postOrderRecursiveHelper(root.left);
		postOrderRecursiveHelper(root.right);
		System.out.print(root.data + " ");
	}
