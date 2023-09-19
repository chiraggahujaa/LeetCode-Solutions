class TreeAncestor {
    int[][] up;
    int[] depth;
    int log;
    public TreeAncestor(int n, int[] parent) {
        this.log = (int)(Math.log(n) / Math.log(2)) + 1;
        
        this.depth = new int[n];
        this.up = new int[n][log];

        for(int v=0; v<n; v++)
          up[v][0] = parent[v];
        

        for(int j=1; j<log; j++){
          for(int v=0; v<n; v++){
            if(up[v][j-1] == -1)
              up[v][j] = -1;
            else
              up[v][j] = up[up[v][j-1]][j-1];
          }
        }
        
    }
    public int getKthAncestor(int node, int k) {        
        for(int i=0; i<log && node > -1; i++){
          if(((k >> i) & 1) != 0){
            node = up[node][i];
          }
        }

        return node;
    }
}