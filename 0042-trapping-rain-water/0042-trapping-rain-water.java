class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int res = 0;
        int maxLeft = height[0], maxRight = height[n-1];
        int i = 0, j=n-1;
        while(i < j){
            if(maxLeft <= maxRight){
                res += Math.max(maxLeft - height[i], 0);
                maxLeft = Math.max(maxLeft, height[i]);
            }
            else{
                res += Math.max(maxRight - height[j], 0);
                maxRight = Math.max(maxRight, height[j]);
            }

            if(maxLeft <= maxRight)
                i++;
            else
                j--;

        }

        return res;
    }
}