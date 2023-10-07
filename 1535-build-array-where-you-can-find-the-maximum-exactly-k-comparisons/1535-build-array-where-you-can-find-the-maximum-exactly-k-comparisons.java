class Solution {
    int n, m;
    int mod = 1000000007;
    public int numOfArrays(int n, int m, int k) {
        // at every index in the array we have m choices
        // if element taken is greater than prevMax element then cost++, prevMax updated to curr element
        // if element taken is less than or equals to prevMax then cost remains same, and the prevMax remains same

        this.n = n;
        this.m = m;

        long[][][] dp = new long[n][m+1][k+1];
        for(long[][] arr : dp)
            for(long[] row : arr)
                Arrays.fill(row, -1);

        return (int)f(0, -1, k, dp);
    }
    public long f(int i, int prevMax, int k, long[][][] dp){
        if(k < 0)
            return 0;
        if(i == n){
            if(k == 0)
                return 1;
            else
                return 0;
        }

        if(prevMax != -1 && dp[i][prevMax][k] != -1)
            return dp[i][prevMax][k];
        
        long res = 0;
        for(int j=1; j<=m; j++){
            if(j > prevMax)
                res += f(i+1, j, k-1, dp);
            else
                res += f(i+1, prevMax, k, dp);
        }

        res %= mod;
        if(prevMax != -1)
            dp[i][prevMax][k] = res;

        return res;
    }
}