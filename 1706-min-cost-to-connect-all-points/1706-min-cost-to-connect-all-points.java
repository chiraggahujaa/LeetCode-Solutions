class Pair{
    int u, wt;
    Pair(int u, int wt){
        this.u = u;
        this.wt = wt;
    }
    public String toString(){
        return "("+u+" "+wt+")";
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        for(int u=0; u<n; u++){
            for(int v=u+1; v<n; v++){
                int wt = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);

                adj.computeIfAbsent(u, y -> new ArrayList<>()).add(new Pair(v, wt));
                adj.computeIfAbsent(v, y -> new ArrayList<>()).add(new Pair(u, wt));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.wt - b.wt
        );
        boolean[] vis = new boolean[n];

        pq.offer(new Pair(0, 0));
        int res = 0;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int u = p1.u, wt1 = p1.wt;

            if(vis[u])
                continue;
            
            vis[u] = true;
            res += wt1;

            for(Pair p2 : adj.getOrDefault(u, new ArrayList<>()))
                pq.offer(p2);
        }

        return res;
    }
}