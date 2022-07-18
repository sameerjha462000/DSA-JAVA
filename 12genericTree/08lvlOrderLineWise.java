	public static void levelOrderLineWise(node root){
		Queue<node> curr = new ArrayDeque<>();
		Queue<node> next = new ArrayDeque<>();
		levelOrderLineWiseHelper(root,curr,next);
	}

	public static void levelOrderLineWiseHelper(node root,Queue<node> curr,Queue<node> next){
		curr.add(root);

		while(!curr.isEmpty()){
			node removed = curr.remove();
			for(node child : removed.children)
			{
				next.add(child);
			}
			System.out.print(removed.data+" ");
			if(curr.isEmpty()){
				// swap curr and next
				Queue<node> temp = curr;
				curr = next;
				next = temp;

				// since curr is empty so print next line
				System.out.println();
			}
		}
	}
