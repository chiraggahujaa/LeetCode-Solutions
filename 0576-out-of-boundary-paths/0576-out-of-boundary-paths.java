class Solution {
    int n, m;
    int[][] moves;
    int mod;
    public int findPaths(int n, int m, int maxMove, int startRow, int startColumn) {
        this.n = n;
        this.m = m;
        this.mod = 1000000007;
        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        int[][][] dp = new int[n][m][maxMove+1];
        for(int[][] arr : dp)
            for(int[] row : arr)
                Arrays.fill(row, -1);

        return f(startRow, startColumn, maxMove, dp);
    }
    public int f(int i, int j, int maxMoves, int[][][] dp){
        if(i<0 || j<0 || i>=n || j>= m)
            return 1;
        if(maxMoves <= 0)
            return 0;

        if(dp[i][j][maxMoves] != -1)
            return dp[i][j][maxMoves];
        
        int count = 0;
        for(int[] moveTo : moves){
            int  ii = i + moveTo[0];
            int jj = j + moveTo[1];

            count = (count + f(ii, jj, maxMoves-1, dp))%mod;
        }

        return dp[i][j][maxMoves] = count % mod;
    }
}