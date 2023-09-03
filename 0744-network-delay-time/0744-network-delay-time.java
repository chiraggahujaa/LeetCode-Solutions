class Pair{
    int u, t;
    Pair(int u, int time){
        this.u = u;
        this.t = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            adj.computeIfAbsent(u, y -> new ArrayList<>()).add(new Pair(v, t));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.t - b.t
        );
        int[] res = new int[n+1];

        Arrays.fill(res, Integer.MAX_VALUE);

        pq.offer(new Pair(k, 0));
        res[k] = 0;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int u = p1.u, t1 = p1.t;

            for(Pair p2 : adj.getOrDefault(u, new ArrayList<>())){
                int v = p2.u, t2 = p2.t;

                if(t1 + t2 < res[v]){
                    res[v] = t1 + t2;
                    pq.offer(new Pair(v, res[v]));
                }
            }
        }

        int maxVal = 0;
        for(int i=1; i<=n; i++){
            maxVal = Math.max(maxVal, res[i]);
        }

        return maxVal == Integer.MAX_VALUE ? -1 : maxVal;
    }
}