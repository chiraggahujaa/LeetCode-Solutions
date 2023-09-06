class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while(i < j){
            int mid = i + (j-i)/2;
            int sum = nums[i] + nums[j];
            
            if(sum == target)
                return new int[]{i+1, j+1};
            else if(sum < target){
                if(nums[mid] + nums[j] < target)
                    i = mid;
                else
                    i++;
            }
            else{
                if(nums[mid] + nums[i] > target)
                    j = mid;
                else
                    j--;
            }
        }

        return new int[]{-1, -1};
    }
}