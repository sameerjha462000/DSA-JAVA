  private static boolean isConnected(ArrayList<Edge>[] graph)
   {
      int V = graph.length;
      boolean[] visited = new boolean[V];
      int count = 0; // Number of times we need to run dfs
      for(int i = 0 ; i < V ; i++)
      {
         if(!visited[i])
         {
            count++;
            // if we have to run dfs more than once then our graph is disconnected...
            if(count > 1)
            {
               return false;
            }
            helper(graph,i,visited); // dfs
         }
      }
      return true;
   }

   private static void helper(ArrayList<Edge>[] graph,int start,boolean[] visited)
   {
      visited[start] = true;

      for(Edge e : graph[start])
      {
         if(!visited[e.nbr])
         {
            helper(graph,e.nbr,visited);
         }
      }
   }
