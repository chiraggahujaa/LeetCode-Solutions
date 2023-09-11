class Pair{
    int u, t;
    Pair(int u, int t){
        this.u = u;
        this.t = t;
    }
}
class Solution {
    public int networkDelayTime(int[][] edges, int n, int k) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            adj.computeIfAbsent(u, y-> new ArrayList<>()).add(new Pair(v, t));
        }

        int[] res = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.t - b.t
        );

        pq.offer(new Pair(k, 0));

        Arrays.fill(res, Integer.MAX_VALUE);
        res[k] = 0;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int u = p1.u, t1 = p1.t;

            for(Pair p2 : adj.getOrDefault(u, new ArrayList<>())){
                int v = p2.u, t2 = p2.t;

                if(res[v] > t1 + t2){
                    res[v] = t1 + t2;
                    pq.offer(new Pair(v, res[v]));
                }
            }
        }

        int max = 0;
        for(int u=1; u<=n; u++)
            max = Math.max(max, res[u]);
        
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}