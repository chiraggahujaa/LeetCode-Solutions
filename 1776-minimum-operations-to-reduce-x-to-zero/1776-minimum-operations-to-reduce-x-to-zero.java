class Solution {
    int n;
    public int minOperations(int[] nums, int x) {
        this.n = nums.length;

        int target = -x;
        for(int el : nums) target += el;

        if(target == 0) return n;
        
        int len = longestSubarrayLen(nums, target);

        if(len == Integer.MIN_VALUE)
            return -1;
        
        return nums.length - len;
    }
    public int longestSubarrayLen(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = Integer.MIN_VALUE;

        int pre = 0;
        for(int i=0; i<n; i++){
            pre += nums[i];
            if(map.containsKey(pre - target))
                res = Math.max(res, i - map.get(pre - target));
            
            map.put(pre, i);
        }

        return res;
    }
}