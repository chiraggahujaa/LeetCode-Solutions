class Solution {
    int n;
    int[][] dp;
    public int rob(int[] nums) {
        this.n = nums.length;
        this.dp = new int[n][3];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, false, nums);
    }
    public int f(int i, boolean prevRobbed, int[] nums){
        if(i >= n)
            return 0;

        int j = prevRobbed ? 1 : 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        if(!prevRobbed)
            take = nums[i] + f(i+1, true, nums);
        
        int notTake = f(i+1, false, nums);
        return dp[i][j] = Math.max(take, notTake);
    }
}