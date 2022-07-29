private static void printAllPaths(ArrayList<edge>[] graph,int src,int dest)
    {
        StringBuilder sb = new StringBuilder(""+src);
        boolean[] vis = new boolean[graph.length];

        dfs(graph,src,dest,vis,sb);
    }

    private static void dfs(ArrayList<edge>[] graph,int src,int dest,boolean[] vis,StringBuilder sb)
    {
        vis[src] = true;

        if(src == dest)
        {
            System.out.println(sb);
            vis[src] = false;
            return ;
        }

        for(edge e : graph[src])
        {
            if(!vis[e.nbr])
            {
                dfs(graph,e.nbr,dest,vis,sb.append(e.nbr));
                sb.deleteCharAt(sb.length()-1);
            }
        }

        vis[src] = false;
    }
