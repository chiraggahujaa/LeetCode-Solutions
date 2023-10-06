class Solution {
    public int integerBreak(int n) {
        // edge cases (bz must break into 2)
        // 2 -- 1*1
        // 3 -- 2*1
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return f(n, dp);
    }
    public int f(int n, int[] dp){
        if(n == 0)
            return 1;

        if(dp[n] != -1)
            return dp[n];

        int prod = 1;
        for(int i=1; i<=n; i++)
            prod = Math.max(prod, i * f(n-i, dp));

        return dp[n] = prod;
    }
}