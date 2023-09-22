class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int k = n/3;

        int[][][] dp = new int[n][k+1][2];
        for(int[][] arr : dp)
            for(int[] row : arr)
                Arrays.fill(row, -1);
        
        int res1 = f(0, k, 1, n-1, slices, dp);

        for(int[][] arr : dp)
            for(int[] row : arr)
                Arrays.fill(row, -1);
        int res2 = f(1, k, 1, n, slices, dp);

        return Math.max(res1, res2);
    }
    public int f(int i, int k, int canTake, int n, int[] slices, int[][][] dp){
        if(k == 0)
            return 0;
        if(i == n)
            return 0;

        if(dp[i][k][canTake] != -1)
            return dp[i][k][canTake];
        
        int take = 0;
        if(canTake == 1)
            take = slices[i] + f(i+1, k-1, 0, n, slices, dp);
        int notTake = f(i+1, k, 1, n, slices, dp);

        return dp[i][k][canTake] = Math.max(take, notTake);
    }
}