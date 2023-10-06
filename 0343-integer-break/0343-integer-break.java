class Solution {
    public int integerBreak(int n) {
        // logic -- 
        // every integer n can be broken down into 1 to n
        // so by dp we try for each of them, i.e. for every integer we break that down into 1 to n.
        // i.e. if we break n into i and n-i then product is i*f(n-i)
        // and we take maximum of all these values

        // edge cases (bz must break into 2)
        // only for 2 and 3 the product after breaking is less than their value. that's value we have to handle them diffrently
        // 2 -- 1*1 < 2
        // 3 -- 2*1 < 3

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