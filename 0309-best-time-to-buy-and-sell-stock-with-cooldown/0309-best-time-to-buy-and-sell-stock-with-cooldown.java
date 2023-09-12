class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        this.n = prices.length;
        this.dp = new int[n][3];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, true, prices);
    }
    public int f(int i, boolean canBuy, int[] prices){
        if(i >= n)
            return 0;
        
        int j = canBuy ? 1 : 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int res = 0;
        if(canBuy){
            res = Math.max(f(i+1, true, prices), res);
            res = Math.max(-prices[i] + f(i+1, false, prices), res);
        }
        else{
            res = Math.max(f(i+1, false, prices), res);
            res = Math.max(prices[i] + f(i+2, true, prices), res);
        }

        return dp[i][j] = res;
    }
}