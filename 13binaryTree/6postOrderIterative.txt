	void postOrderIterative()
	{
		Stack<node> mainStack = new Stack<>();
		Stack<node> helperStack = new Stack<>();

		mainStack.push(root);

		while(!mainStack.isEmpty())
		{
			node removed = mainStack.pop();

			helperStack.push(removed);

			if(removed.left != null)
			{
				mainStack.push(removed.left);
			}

			if(removed.right != null)
			{
				mainStack.push(removed.right);
			}
		}

		while(!helperStack.isEmpty())
		{
			System.out.print(helperStack.pop().data+ " ");
		}
	}
