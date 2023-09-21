class Solution {
    int n;
    int[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
        this.n = nums1.length;
        this.dp = new int[n][3];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, nums1, nums2);
    }
    public int f(int i, int prevSwapped, int[] nums1, int[] nums2){
        if(i == n)
            return 0;

        if(dp[i][prevSwapped+1] != -1)
            return dp[i][prevSwapped+1];

        int res = Integer.MAX_VALUE;
        int prev1 = i==0 ? -1 : nums1[i-1], prev2 = i==0 ? -1 : nums2[i-1];

        if(prevSwapped == 1){
            int temp = prev1;
            prev1 = prev2;
            prev2 = temp;
        }

        // not swap
        if(nums1[i] > prev1 && nums2[i] > prev2)
            res = Math.min(res, f(i+1, 0, nums1, nums2));
        
        // swap
        if(nums1[i] > prev2 && nums2[i] > prev1)
            res = Math.min(res, 1 + f(i+1, 1, nums1, nums2));
        
        return dp[i][prevSwapped+1] = res;
    }
}