class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        HashMap<Integer, List<Integer>> adj = new  HashMap<>();
        int[] inDeg = new int[V];
        for(int u=0; u<graph.length; u++){
            for(int i=0; i<graph[u].length; i++){
                int v = graph[u][i];

                adj.computeIfAbsent(v, y-> new ArrayList<>()).add(u);
                inDeg[u]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for(int u=0; u<V; u++)
            if(inDeg[u] == 0)
                q.offer(u);

        while(!q.isEmpty()){
            int u = q.poll();
            res.add(u);

            for(int v : adj.getOrDefault(u, new ArrayList<>())){
                inDeg[v]--;
                if(inDeg[v] == 0)
                    q.offer(v);
            }
        }

        Collections.sort(res);

        return res;
    }
}