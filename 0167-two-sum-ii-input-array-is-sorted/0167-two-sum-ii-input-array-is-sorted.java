class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while(i < j){
            int mid = i + (j-i)/2;
            int sum = nums[i] + nums[j];
            
            if(sum == target)
                return new int[]{i+1, j+1};
            else if(sum < target){
			// if nums[i] + nums[j] is less than target, then we have to increment i, to optimize it, we are also checking, if nums[mid] + nums[j] is still less than target, which means that answer is not present in 1st part of array (before mid). so just i = mid.
                if(nums[mid] + nums[j] < target)
                    i = mid;
                else
                    i++;
            }
            else{
				// similar explaination for this one.
                if(nums[mid] + nums[i] > target)
                    j = mid;
                else
                    j--;
            }
        }

        return new int[]{-1, -1};
    }
}