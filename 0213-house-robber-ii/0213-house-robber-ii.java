class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        this.dp = new int[n][3];

        if(n == 1)
            return nums[0];

        for(int[] row : dp)
            Arrays.fill(row, -1);
        int res1 = f(0, n-1, false, nums);

        for(int[] row : dp)
            Arrays.fill(row, -1);
        int res2 = f(1, n, false, nums);

        return Math.max(res1, res2);
    }
    public int f(int i, int n, boolean prevRobbed, int[] nums){
        if(i >= n)
            return 0;

        int j = prevRobbed ? 1 : 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        if(!prevRobbed)
            take = nums[i] + f(i+1, n, true, nums);
        
        int notTake = f(i+1, n, false, nums);
        return dp[i][j] = Math.max(take, notTake);
    }
}