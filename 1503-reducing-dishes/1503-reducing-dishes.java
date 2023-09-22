class Solution {
    int n;
    public int maxSatisfaction(int[] satisfaction) {
        this.n = satisfaction.length;
        Arrays.sort(satisfaction);

        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 1, satisfaction, dp);
    }
    public int f(int i, int num, int[] satisfaction, int[][] dp){
        if(i == n)
            return 0;

        if(dp[i][num] != -1)
            return dp[i][num];

        int take = num*satisfaction[i] + f(i+1, num+1, satisfaction, dp);
        int notTake = f(i+1, num, satisfaction, dp);

        return dp[i][num] = Math.max(take, notTake);
    }
}