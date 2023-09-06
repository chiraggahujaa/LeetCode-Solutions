class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;

        Arrays.sort(nums);

        int i = 1;
        int res = 1;
        int currCount = 1;

        while(i < n){
            if(nums[i] == nums[i-1]){
                i++;
                continue;
            }
            else if(nums[i] == nums[i-1] + 1){
                currCount++;
                res = Math.max(currCount, res);
            }
            else
                currCount = 1;
            i++;
        }

        return res;
    }
}