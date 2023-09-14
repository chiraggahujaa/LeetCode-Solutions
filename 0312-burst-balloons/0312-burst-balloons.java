class Solution {
    int[] nums;
    int n;
    int[][] dp;
    public int maxCoins(int[] oldNums) {
        this.n = oldNums.length;
        this.nums = new int[n+2];
        this.dp = new int[n+1][n+1];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        nums[0] = 1;
        for(int i=0; i<n; i++)
            nums[i+1] = oldNums[i];
        nums[n+1] = 1;

        return f(1, n);
    }
    public int f(int start, int end){
        if(start > end)
            return 0;

        if(dp[start][end] != -1)
            return dp[start][end];
        
        int res = 0;
        for(int j=start; j<=end; j++){
            int curr = nums[start-1] * nums[end+1] * nums[j] + f(start, j-1) + f(j+1, end);
            res = Math.max(res, curr);
        }

        return dp[start][end] = res;
    }
}