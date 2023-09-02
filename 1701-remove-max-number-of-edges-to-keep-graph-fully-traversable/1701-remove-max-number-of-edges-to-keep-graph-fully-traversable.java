class UnionFind{
    int noOfNodes;
    int[] parent, rank;

    UnionFind(int n){
        this.noOfNodes = 0;
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

        this.noOfNodes++;
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a,b) -> b[0] - a[0]);

        UnionFind uf1 = new UnionFind(n);
        UnionFind uf2 = new UnionFind(n);

        int extraEdges = 0;
        for(int[] edge : edges){
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(type == 1){
                if(uf1.find(u) == uf1.find(v))
                    extraEdges++;
                else
                    uf1.union(u, v);
            }
            else if(type == 2){
                if(uf2.find(u) == uf2.find(v))
                    extraEdges++;
                else
                    uf2.union(u, v);
            }
            else{
                if(uf1.find(u) == uf1.find(v) && uf2.find(u) == uf2.find(v))
                    extraEdges++;
                else{
                    uf1.union(u,v);
                    uf2.union(u,v);
                } 
            }
        }

        // System.out.println(uf1.noOfNodes + " " + uf2.noOfNodes);

        if(uf1.noOfNodes+1 < n || uf2.noOfNodes+1 < n)
            return -1;

        return extraEdges;
    }
}