class UnionFind{
    int[] parent, rank;

    UnionFind(int n){
        this.parent = new int[n+1];
        this.rank = new int[n+1];

        for(int i=0; i<=n; i++)
            parent[i] = i;
    }

    public int find(int i){
        if(i == parent[i])
            return i;
        
        return parent[i] = find(parent[i]);
    }
    public void union(int a, int b){
        int aPar = find(a);
        int bPar = find(b);
        
        if(aPar == bPar) return;
        
        if(rank[aPar] > rank[bPar])
            parent[bPar] = aPar;
        else if(rank[aPar] < rank[bPar])
            parent[aPar] = bPar;
        else{
            parent[bPar] = aPar;
            rank[aPar]++;
        }
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<int[]> edges = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int dis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{i, j, dis});
            }
        }

        Collections.sort(edges, (a,b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int cost = 0;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int dis = edge[2];

            if(uf.find(u) != uf.find(v)){
                uf.union(u,v);
                cost += dis;
            }
        }

        return cost;
    }
}