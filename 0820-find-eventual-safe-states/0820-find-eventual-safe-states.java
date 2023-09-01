class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;

        boolean[] vis = new boolean[V];
        boolean[] inRec = new boolean[V];

        for(int u=0; u<V; u++){
            if(!vis[u])
                dfs(u, vis, inRec, graph);
        }

        List<Integer> res = new ArrayList<>();
        for(int u=0; u<V; u++)
            if(!inRec[u])
                res.add(u);

        return res;
    }
    public boolean dfs(int u, boolean[] vis, boolean[] inRec, int[][] graph){
        vis[u] = true;
        inRec[u] = true;

        for(int v : graph[u]){
            if(!vis[v] && dfs(v, vis, inRec, graph))
                return true;

            else if(inRec[v])
                return true;

        }

        inRec[u] = false;
        return false;
    }
}