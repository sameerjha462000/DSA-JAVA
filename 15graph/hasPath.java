    private static boolean hasPath(ArrayList<Edge>[] graph, int src,int dest)
    {
        boolean[] vis = new boolean[graph.length];

        return dfs(graph,src,dest,vis);
    }

    private static boolean dfs(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis)
    {
        vis[src] = true;

        if(src == dest)
            return true;

        for(Edge e : graph[src])
        {
            if(!vis[e.nbr])
            {
                if(dfs(graph,e.nbr,dest,vis))
                    return true;
            }
        }

        return false;
    }
