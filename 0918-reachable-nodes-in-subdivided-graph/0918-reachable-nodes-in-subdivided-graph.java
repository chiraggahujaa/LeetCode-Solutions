class Pair{
    int u, cnt;
    Pair(int u, int cnt){
        this.u = u;
        this.cnt = cnt;
    }
}
class Solution {
    int[][] adj;
    int n;
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        this.adj = new int[n][n];
        this.n = n;

        for(int[] row : adj)
            Arrays.fill(row, -1);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];

            adj[u][v] = cnt;
            adj[v][u] = cnt;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.cnt - a.cnt
        );
        boolean[] vis = new boolean[n];

        pq.offer(new Pair(0, maxMoves));

        int res = 0;
        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int u = p1.u, remCnt = p1.cnt;

            if(vis[u])
                continue;

            res++;
            vis[u] = true;

            for(int v=0; v<n; v++){
                if(adj[u][v] == -1)
                    continue;
                    
                int cnt = adj[u][v];

                if(!vis[v] && cnt < remCnt)
                    pq.offer(new Pair(v, remCnt - cnt - 1));

                int minCost = Math.min(cnt, remCnt);

                adj[u][v] -= minCost;
                adj[v][u] -= minCost;

                res += minCost;
            }
        }

        return res;
    }
}