class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][query_glass+1];
        for(double[] row : dp)
            Arrays.fill(row, -1.0);

        double res = f(query_row, query_glass, poured, dp);
        return res >= 1 ? 1 : res;
    }
    public double f(int i, int j, int poured, double[][] dp){
        if(i==0 && j==0){
            return poured;
        }
        if(i<0 || j<0 || i<j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        double upLeft = (f(i-1, j-1, poured, dp)-1)/2.0;
        double upRight = (f(i-1, j, poured, dp)-1)/2.0;

        if(upLeft < 0)
            upLeft = 0;
        if(upRight < 0)
            upRight = 0;

        return dp[i][j] = upLeft + upRight;
    }
}