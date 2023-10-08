class Solution {
    int n1, n2;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // O(n^3) solution

        this.n1 = nums1.length;
        this.n2 = nums2.length;

        int[][][] dp = new int[n1][n2][2];
        for(int[][] arr : dp)
            for(int[] row : arr)
                Arrays.fill(row, -1);

        return f(0, 0, 0, nums1, nums2, dp);
    }
    public int f(int i, int j, int takenOnce, int[] nums1, int[] nums2, int[][][] dp){
        if(i == n1 || j == n2)
            if(takenOnce == 1)
                return 0;
            else
                return -10000;

        if(dp[i][j][takenOnce] != -1)
            return dp[i][j][takenOnce];

        int take = nums1[i] * nums2[j] + f(i+1, j+1, 1, nums1, nums2, dp);
        int notTake = Math.max(f(i+1, j, takenOnce, nums1, nums2, dp), f(i, j+1, takenOnce, nums1, nums2, dp));

        return dp[i][j][takenOnce] = Math.max(take, notTake);
    }
}