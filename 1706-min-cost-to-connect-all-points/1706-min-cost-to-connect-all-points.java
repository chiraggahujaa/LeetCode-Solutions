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

        for(int u=0; u<n; u++){
            for(int v=u+1; v<n; v++){
                int wt = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);

                int[] edge = new int[3];
                edge[0] = u;
                edge[1] = v;
                edge[2] = wt;

                edges.add(edge);
            }
        }

        Collections.sort(edges, (a,b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int res = 0;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(uf.find(u) != uf.find(v)){
                uf.union(u,v);
                res += wt;
            }
        }

        return res;
    }
}