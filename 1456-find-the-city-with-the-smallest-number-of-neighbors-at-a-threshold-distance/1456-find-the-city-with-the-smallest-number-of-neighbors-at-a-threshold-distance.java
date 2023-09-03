class Pair{
    int u, dis;
    Pair(int u, int dis){
        this.u = u;
        this.dis = dis;
    }
}
class Solution {
    HashMap<Integer, List<Pair>> adj;
    int threshold, n;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        this.adj = new HashMap<>();
        this.threshold = distanceThreshold;
        this.n = n;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int dis = edge[2];

            adj.computeIfAbsent(u, y -> new ArrayList<>()).add(new Pair(v, dis));
            adj.computeIfAbsent(v, y -> new ArrayList<>()).add(new Pair(u, dis));
        }

        int minVal = Integer.MAX_VALUE, res = 0;
        for(int u=0; u<n; u++){
            int val = dijsktra(u);
            // System.out.println(u + " " + val);
            if(val <= minVal){
                res = u;
                minVal = val;
            }
        }

        return res;
    }
    public int dijsktra(int start){
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.dis - b.dis
        );
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);

        pq.offer(new Pair(start, 0));
        res[start] = 0;

        while(!pq.isEmpty()){
            Pair p1 = pq.poll();
            int u = p1.u, dis1 = p1.dis;

            for(Pair p2 : adj.getOrDefault(u, new ArrayList<>())){
                int v = p2.u, dis2 = p2.dis;

                if(dis1 + dis2 <= threshold && dis1 + dis2 < res[v]){
                    res[v] = dis1 + dis2;
                    pq.offer(new Pair(v, res[v]));
                }
            }
        }

        int count = 0;
        for(int u=0; u<n; u++){
            if(u == start)
                continue;
            
            if(res[u] != Integer.MAX_VALUE)
                count++;
        }

        // System.out.println(start + " " + Arrays.toString(res));

        return count;
    }
}