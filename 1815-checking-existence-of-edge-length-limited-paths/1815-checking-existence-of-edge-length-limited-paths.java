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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edges, int[][] oldQueries) {
        int qLen = oldQueries.length;
        int[][] queries = new int[qLen][4];
        for(int i=0; i<qLen; i++){
            queries[i][0] = oldQueries[i][0];
            queries[i][1] = oldQueries[i][1];
            queries[i][2] = oldQueries[i][2];
            queries[i][3] = i;
        }

        Arrays.sort(queries, (a,b) -> a[2] - b[2]);
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        boolean[] res = new boolean[qLen];

        int i = 0;
        for(int[] query : queries){
            int u = query[0];
            int v = query[1];
            int limit = query[2];

            while(i<edges.length && edges[i][2] < limit){
                int uu = edges[i][0];
                int vv = edges[i][1];

                uf.union(uu, vv);
                i++;
            }

            if(uf.find(u) == uf.find(v))
                res[query[3]] = true;
        }

        return res;
    }
}