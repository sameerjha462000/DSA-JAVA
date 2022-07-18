	public static void levelOrderLineWiseZigZag(node root){
		Stack<node> curr = new Stack<>();
		Stack<node> next = new Stack<>();

		levelOrderLineWiseZigZagHelper(root,curr,next);
	}

	public static void levelOrderLineWiseZigZagHelper(node root,Stack<node> curr,Stack<node> next){
		curr.push(root);
		int level = 0;

		while(!curr.isEmpty()){
			node removed = curr.pop();

			if(level % 2 == 0){
				for(node child : removed.children)
					next.push(child);
			}else{
				for(int i=removed.children.size()-1;i>=0;i--){
					next.push(removed.children.get(i));
				}
			}

			System.out.print(removed.data+" ");

			if(curr.isEmpty())
			{
				Stack<node> temp = curr;
				curr = next;
				next = temp;
				System.out.println();
				level++;
			}
		}
	}
