class Pair{
    int i, j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    int n, m;
    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        this.m = grid.length;
        int[][] moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> grid[a.i][a.j] - grid[b.i][b.j]
        );
        boolean[][] vis = new boolean[n][m];

        pq.offer(new Pair(0,0));

        int max = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i = p.i, j = p.j;

            max = Math.max(max, grid[i][j]);
            vis[i][j] = true;

            if(i == n-1 && j == m-1)
                return max;

            for(int[] moveTo : moves){
                int ii = i + moveTo[0];
                int jj = j + moveTo[1];

                if(isValid(ii, jj) && !vis[ii][jj])
                    pq.offer(new Pair(ii, jj));
            }
        }
        
        return -1;
    }
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}