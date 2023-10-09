class Solution {
    int n;
    public int[] searchRange(int[] nums, int target) {
        this.n = nums.length;
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }
    public int findFirst(int[] nums, int target){
        int lo = 0, hi = n-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != nums[mid])
                    return mid;
                hi = mid - 1;
            }
            else if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;
    }
    public int findLast(int[] nums, int target){
        int lo = 0, hi = n-1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                if(mid == n-1 || nums[mid+1] != nums[mid])
                    return mid;
                lo = mid + 1;
            }
            else if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return -1;
    }
}