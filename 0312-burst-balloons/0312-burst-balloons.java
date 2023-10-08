class Solution {
    int n;
    public int maxCoins(int[] nums) {
        // we can start from the last burst to first burst
        // [3,1,5,8]
        // let's say we have 8 remaining at last => res += 1*8*1
        // [8] => let's say we have 3 at 2nd last => res += 1*3*8
        // [3,8] => let's say we have 5 at 3rd last => res += 3*5*8
        // [3,5,8] => let's say we have 1 at 4th last => res += 3*1*5
        // so res = 167

        // [1,3,1,5,8,1] -- extened array
        // i=0, j=n+1, k can be between i and j (both exclusive)
        // choose k, then f(i, k) + f(k, j) + arr[i]*arr[k]*arr[j] => get max of this
        
        this.n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = 1; arr[n+1] = 1;
        for(int i=1; i<=n; i++)
            arr[i] = nums[i-1];

        int[][] dp = new int[n+2][n+2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, n+1, arr, dp);
    }
    public int f(int i, int j, int[] nums, int[][] dp){
        if(i+1 >= j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int res = 0;
        for(int k=i+1; k<j; k++)
            res = Math.max(nums[i]*nums[k]*nums[j] + f(i, k, nums, dp) + f(k, j, nums, dp), res);
        
        return dp[i][j] = res;
    }
}