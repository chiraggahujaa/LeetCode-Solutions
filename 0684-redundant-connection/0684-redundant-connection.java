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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n);
        int[] res = new int[2];
        
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(uf.find(u) == uf.find(v)){
                res[0] = u;
                res[1] = v;
            }else{
                uf.union(u,v);
            }
        }

        return res;
    }
}