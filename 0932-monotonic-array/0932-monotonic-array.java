class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;

        boolean isInc = true, isDec = true;
        for(int i=1; i<n; i++){
            if(!(isInc || isDec))
                return false;
            if(nums[i] < nums[i-1])
                isInc = false;
            if(nums[i] > nums[i-1])
                isDec = false;
        }

        return isInc || isDec;
    }
}