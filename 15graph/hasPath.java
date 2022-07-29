    private static boolean hasPath(ArrayList<edge>[] graph, int src,int dest)
    {
        boolean[] vis = new boolean[graph.length];

        return dfs(graph,src,dest,vis);
    }

    private static boolean dfs(ArrayList<edge>[] graph,int src,int dest,boolean[] vis)
    {
        vis[src] = true;

        if(src == dest)
            return true;

        for(edge e : graph[src])
        {
            if(!vis[e.dest])
            {
                if(dfs(graph,e.dest,dest,vis))
                    return true;
            }
        }

        return false;
    }
