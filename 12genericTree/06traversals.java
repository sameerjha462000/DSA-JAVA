	public static void traversals(node root)
	{

		// node pre means node pr aakr sbse pehla kaam
		System.out.println("node pre " + root.data);

		for(node child : root.children){

			// edge pre means node pr call lgne se pehle wala kaam
			System.out.println("edge pre " + root.data + "--" + child.data);

			traversals(child);

			// edge post means node pr call over hone ke baad wala kaam
			System.out.println("edge post " + root.data + "--" + child.data);
		}

		// node post means node pr call over hone se pehle last kaam
		System.out.println("node post " + root.data);
  	}
