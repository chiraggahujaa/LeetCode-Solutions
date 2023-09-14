class Solution {
    int n;
    int[] dp;
    public boolean canJump(int[] nums) {
        this.n = nums.length;
        this.dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, nums);
    }

    public boolean f(int i, int[] nums){
        if(i >= n-1)
            return true;

        if(dp[i] != -1)
            return dp[i] == 1;

        for(int jump=1; jump<=nums[i]; jump++){
            if(f(i+jump, nums)){
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}