class Solution {
    int len;
    int mod = 1000000007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.len = group.length;
        int[][][] dp = new int[len][n+1][minProfit+1];
        for(int[][] arr : dp)   
            for(int[] row : arr)
                Arrays.fill(row, -1);
            
        return f(0, n, minProfit, group, profit, dp);
    }
    public int f(int i, int n, int minProfit, int[] group, int[] profit, int[][][] dp){
        if(i == len){
            if(minProfit <= 0 && n>=0)
                return 1;
            else
                return 0;
        }
        if(n < 0)
            return 0;
        if(minProfit <= 0)
            minProfit = 0;

        if(dp[i][n][minProfit] != -1)
            return dp[i][n][minProfit];
        
        int take = f(i+1, n-group[i], minProfit - profit[i], group, profit, dp) % mod;
        int notTake = f(i+1, n, minProfit, group, profit, dp) % mod;

        return dp[i][n][minProfit] = (take + notTake)%mod;
    }
}