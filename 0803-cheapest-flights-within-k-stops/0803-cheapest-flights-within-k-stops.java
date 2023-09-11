class Pair{
    int u, dis;
    Pair(int u, int dis){
        this.u = u;
        this.dis = dis;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int dis = edge[2];

            adj.computeIfAbsent(u, y->new ArrayList<>()).add(new Pair(v, dis));
        }

        Queue<Pair> q = new ArrayDeque<>();
        int[] res = new int[n];

        q.offer(new Pair(src, 0));
        Arrays.fill(res, Integer.MAX_VALUE);
        res[src] = 0;

        while(!q.isEmpty() && k>=0){
            int size = q.size();
            for(int x=0; x<size; x++){
                Pair p1 = q.poll();
                int u = p1.u, dis1 = p1.dis;

                for(Pair p2 : adj.getOrDefault(u, new ArrayList<>())){
                    int v = p2.u, dis2 = p2.dis;

                    if(res[v] > dis1 + dis2){
                        res[v] = dis1 + dis2;
                        q.offer(new Pair(v, res[v]));
                    }
                }
            }
            k--;
        }

        return res[dst] == Integer.MAX_VALUE ? -1 : res[dst];
    }
}