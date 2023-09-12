class Solution {
    int n;
    int[][] dp;
    public int change(int amt, int[] coins) {
        this.n = coins.length;
        this.dp = new int[n][amt+1];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, amt, coins);
    }
    public int f(int i, int amt, int[] coins){
        if(amt == 0)
            return 1;
        if(amt < 0 || i>=n)
            return 0;

        if(dp[i][amt] != -1)
            return dp[i][amt];

        int take = f(i, amt - coins[i], coins);
        int notTake = f(i+1, amt, coins);

        return dp[i][amt] = take + notTake;
    }
}