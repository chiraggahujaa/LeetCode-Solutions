class Pair{
    int i, j, dis;
    Pair(int i, int j, int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
    public String toString(){
        return "("+i+" "+j+")";
    }
}
class Solution {
    int n;
    int[][] moves;
    public int shortestBridge(int[][] grid) {
        this.n = grid.length;
        this.moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // find any 1
        // run a dfs on it to get that whole island.

        // add that whole island to the queue and run a bfs on it until ou reach another island.
        
        boolean[][] vis = new boolean[n][n];
        int[] ind = new int[2];
        for(int i=0; i<n; i++){
            boolean flag = false;
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    ind[0] = i;
                    ind[1] = j;
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        dfs(ind[0], ind[1], vis, grid);

        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(vis[i][j])
                    q.offer(new Pair(i,j,0));
            }
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0; x<size; x++){
                Pair p = q.poll();
                int i = p.i, j = p.j, dis = p.dis;

                for(int[] moveTo : moves){
                    int ii = i + moveTo[0], jj = j + moveTo[1];

                    if(!isValid(ii, jj))
                        continue;

                    if(!vis[ii][jj] && grid[ii][jj] == 1)
                        return dis;

                    if(!vis[ii][jj]){
                        q.offer(new Pair(ii,jj,dis+1));
                        vis[ii][jj] = true;
                    }
                }
            }
        }

        return 0;
    }
    public void dfs(int i, int j, boolean[][] vis, int[][] grid){
        vis[i][j] = true;

        for(int[] moveTo : moves){
            int ii = i + moveTo[0], jj = j + moveTo[1];

            if(isValid(ii, jj) && !vis[ii][jj] && grid[ii][jj] == 1)
                dfs(ii, jj, vis, grid);
        }
    }
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<n;
    }
}