class Solution {
    int n;
    public int tallestBillboard(int[] rods) {
        this.n = rods.length;
        int[][] dp = new int[n][5001];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, rods, dp)/2;
    }
    public int f(int i, int diff, int[] rods, int[][] dp){
        if(i == n){
            if(diff == 0)
                return 0;
            else
                return Integer.MIN_VALUE;
        }

        if(dp[i][Math.abs(diff)] != -1)
            return dp[i][Math.abs(diff)];

        int take1 = rods[i] + f(i+1, diff + rods[i], rods, dp);
        int take2 = rods[i] + f(i+1, diff - rods[i], rods, dp);
        int notTake = f(i+1, diff, rods, dp);

        return dp[i][Math.abs(diff)] = Math.max(notTake, Math.max(take1, take2));
    }
}