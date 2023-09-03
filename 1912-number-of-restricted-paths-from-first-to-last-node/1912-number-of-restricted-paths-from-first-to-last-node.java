class Pair{
    int u, wt;
    Pair(int u, int wt){
        this.u = u;
        this.wt = wt;
    }
}
class Solution {
    HashMap<Integer, List<Pair>> adj;
    int n;
    int[] res, dp;
    int mod = 1000000007;
    public int countRestrictedPaths(int n, int[][] edges) {
        this.adj = new HashMap<>();
        this.n = n;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, y -> new ArrayList<>()).add(new Pair(v, wt));
            adj.computeIfAbsent(v, y -> new ArrayList<>()).add(new Pair(u, wt));
        }

        dijkstra(n);

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return dfs(1);
    }
    public void dijkstra(int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.wt - b.wt
        );
        this.res = new int[n+1];

        Arrays.fill(res, Integer.MAX_VALUE);
        res[start] = 0;
        pq.offer(new Pair(start, 0));

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int u = p1.u, wt1 = p1.wt;

            for(Pair p2 : adj.getOrDefault(u, new ArrayList<>())){
                int v = p2.u, wt2 = p2.wt;

                if(res[v] > wt1 + wt2){
                    res[v] = wt1 + wt2;
                    pq.offer(new Pair(v, res[v]));
                }
            }
        }
    }
    public int dfs(int u){
        if(u == n)
            return 1;

        if (dp[u] != -1)
            return dp[u];

        int count = 0;
        for(Pair p : adj.getOrDefault(u, new ArrayList<>())){
            int v = p.u;
            int wt = p.wt;

            if (res[u] > res[v]) {
                count = (count + dfs(v)) % mod;
            }
        }

        return dp[u] = count % mod;
    }
}