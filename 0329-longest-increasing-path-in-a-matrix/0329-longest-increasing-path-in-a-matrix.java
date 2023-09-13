class Solution {
    int n, m;
    int[][] res, moves;
    boolean[][] vis;
    public int longestIncreasingPath(int[][] matrix) {
        this.n = matrix.length;
        this.m = matrix[0].length;
        this.res = new int[n][m];
        this.vis = new boolean[n][m];
        this.moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int[] row : res)
            Arrays.fill(row, 1);
        
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(!vis[i][j])
                    dfs(i,j,matrix);
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                max = Math.max(max, res[i][j]);

        return max;
    }
    public void dfs(int i, int j, int[][] matrix){
        vis[i][j] = true;

        for(int[] moveTo : moves){
            int ii = i + moveTo[0];
            int jj = j + moveTo[1];

            if(isValid(ii, jj) && matrix[i][j] < matrix[ii][jj]){
                if(!vis[ii][jj])
                    dfs(ii, jj, matrix);
                res[i][j] = Math.max(res[i][j], res[ii][jj] + 1);
            }
        }
    }
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}