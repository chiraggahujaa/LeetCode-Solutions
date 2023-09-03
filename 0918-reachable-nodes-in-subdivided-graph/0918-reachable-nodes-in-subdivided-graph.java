class Pair{
    int u, cnt;
    Pair(int u, int cnt){
        this.u = u;
        this.cnt = cnt;
    }
}
class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> adj;
    int n;
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        this.adj = new HashMap<>();
        this.n = n;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int cnt = edge[2];

            adj.computeIfAbsent(u, y -> new HashMap<>()).put(v, cnt);
            adj.computeIfAbsent(v, y -> new HashMap<>()).put(u, cnt);
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

            HashMap<Integer, Integer> map = adj.getOrDefault(u, new HashMap<>());

            for(Map.Entry<Integer, Integer> e : map.entrySet()){
                int v = e.getKey(), cnt = e.getValue();

                System.out.println(u + " " + v);

                if(!vis[v] && cnt < remCnt)
                    pq.offer(new Pair(v, remCnt - cnt - 1));

                int val = Math.min(cnt, remCnt);

                adj.get(u).put(v, adj.get(u).get(v) - val);
                adj.get(v).put(u, adj.get(v).get(u) - val);

                res += val;
            }
        }

        return res;
    }
}