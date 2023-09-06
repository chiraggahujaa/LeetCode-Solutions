class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        System.out.println(i + " " + j);

        while(i < j){
            if(nums[i] + nums[j] == target)
                return new int[]{i+1, j+1};
            else if(nums[i] + nums[j] < target)
                i++;
            else
                j--;
        }

        return new int[]{-1, -1};
    }
}