class Solution {
    public int maxArea(int[] height) {
        int i=0, j=height.length-1;
        int res = 0;
        while(i < j){
            int waterContained = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, waterContained);

            if(height[i] <= height[j])
                i++;
            else
                j--;
        }
        return res;
    }
}