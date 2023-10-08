class UnionFind{
    int n;
    int[] parent, rank;
    UnionFind(int n){
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        
        for(int i=0; i<n; i++)
            parent[i] = i;
    }

    public int find(int u){
        if(u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v){
        int uPar = find(u);
        int vPar = find(v);

        if(uPar == vPar)
            return;

        if(rank[uPar] > rank[vPar])
            parent[vPar] = uPar;
        else if(rank[uPar] < rank[vPar])
            parent[uPar] = vPar;
        else{
            parent[vPar] = uPar;
            rank[uPar]++;
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

                int[] temp = new int[3];
                temp[0] = i;
                temp[1] = j;
                temp[2] = dis;

                edges.add(temp);
            }
        }

        Collections.sort(edges, (a,b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);
        int cost = 0;

        for(int[] edge : edges){
            int u = edge[0], v = edge[1], dis = edge[2];
            
            if(uf.find(u) != uf.find(v)){
                uf.union(u, v);
                cost += dis;
            }
        }

        return cost;
    }
}