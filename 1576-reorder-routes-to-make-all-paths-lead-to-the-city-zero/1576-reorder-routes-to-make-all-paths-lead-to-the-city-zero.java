class Pair{
    int u;
    boolean original;
    Pair(int u, boolean original){
        this.u = u;
        this.original = original;
    }
}
class Solution {
    public int minReorder(int n, int[][] edges) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, x-> new ArrayList<>()).add(new Pair(v, true));
            adj.computeIfAbsent(v, x-> new ArrayList<>()).add(new Pair(u, false));
        }

        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int count = 0;
        while(!q.isEmpty()){
            int u = q.poll();

            for(Pair p : adj.getOrDefault(u, new ArrayList<>())){
                int v = p.u;
                boolean original = p.original;

                if(!vis[v]){
                    q.offer(v);
                    vis[v] = true;

                    if(original)
                        count++;
                }
            }
        }

        return count;
    }
}