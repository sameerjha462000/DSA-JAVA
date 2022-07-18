	public static void levelOrder(node root){
		// In normal traversals we use stack but if we want to access elements levelwise
		// then we use queue
		Queue<node> queue = new ArrayDeque<>();

		queue.add(root);

		while(!queue.isEmpty()){
			node removed = queue.remove();

			for(node child : removed.children)
				queue.add(child);

			System.out.print(removed.data+" ");
		}
	}
