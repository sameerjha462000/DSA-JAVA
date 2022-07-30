   private static ArrayList<ArrayList<Integer>> cc(ArrayList<Edge>[] graph)
   {
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

      boolean[] visited = new boolean[graph.length];

      for(int i = 0 ; i < graph.length;i++)
      {
         if(!visited[i])
         {
            ArrayList<Integer> store = new ArrayList<>();
            helper(graph,visited,i,store);
            ans.add(store);
         }
      }

      return ans;
   }

   private static void helper(ArrayList<Edge>[] graph,boolean[] visited,int start,ArrayList<Integer> store)
   {
      visited[start] = true;

      store.add(start);
      for(Edge e : graph[start])
      {
         if(!visited[e.nbr])
         {
            helper(graph,visited,e.nbr,store);
         }
      }
   }
