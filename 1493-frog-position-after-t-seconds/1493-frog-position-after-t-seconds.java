class Pair{
    double prob;
    int t;
    boolean isLeaf;
    Pair(double prob, int t, boolean isLeaf){
        this.prob = prob;
        this.t = t;
        this.isLeaf = isLeaf;
    }
    // public String toString(){
    //     return "("+ prob + " " + t + " " + isLeaf + ")";
    // }
}
class Solution {
    HashMap<Integer, List<Integer>> adj;
    Pair[] prob;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        // 1 -> at t=0, prob = 1
        // 1 -> at t=1, prob = 0

        // 2 -> 
        // at t=0 -> prob = 0
        // at t=1 -> prob = 0.33
        // at t=2 -> prob = 0
        
        // 4 -> 
        // at t=0 -> prob = 0
        // at t=1 -> prob = 0
        // at t=2 -> prob = 0.33 * 0.5 = 0.166
        // at t=3 -> prob = 0.166
        
        // 7 ->
        // at t=0 -> prob = 0
        // at t=1 -> prob = 0.33
        // at t=2 -> prob = 0.33

        // note -
        // leaf will retain the probablity values whereas the other nodes are active only when their t is reached.
        // prob of child = prob of parent / number of child

        this.adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];

            adj.computeIfAbsent(u, y->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, y->new ArrayList<>()).add(u);
        }

        // dfs
        boolean[] vis = new boolean[n+1];
        this.prob = new Pair[n+1];
        prob[1] = new Pair(1.0, 0, false);

        dfs(1, 1, vis);
        // System.out.println(Arrays.toString(prob));

        double res = prob[target].prob;

        if(prob[target].t == t || (prob[target].t <= t && prob[target].isLeaf))
            return res;

        return 0;
    }
    public void dfs(int u, int t, boolean[] vis){
        vis[u] = true;

        int noOfChild = adj.getOrDefault(u, new ArrayList<>()).size();
        if(u != 1)
            noOfChild --;

        if(noOfChild <= 0){
            prob[u].isLeaf = true;
            return;
        }

        for(int v : adj.get(u)){
            if(vis[v])
                continue;

            double temp = prob[u].prob/noOfChild;
            prob[v] = new Pair(temp, t, false);

            dfs(v, t+1, vis);
        }
    }
}