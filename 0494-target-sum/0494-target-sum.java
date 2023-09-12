class Solution {
    int n;
    HashMap<String, Integer> dp;
    public int findTargetSumWays(int[] nums, int target) {
        this.n = nums.length;
        this.dp = new HashMap<>();
        
        return f(0, target, nums);
    }
    public int f(int i, int target, int[] nums){
        if(i == n){
            if(target == 0)
                return 1;
            else
                return 0;
        }

        String key = i + " " + target;
        if(dp.containsKey(key))
            return dp.get(key);

        int pos = f(i+1, target-nums[i], nums);
        int neg = f(i+1, target+nums[i], nums);

        dp.put(key, pos + neg);
        return pos + neg;
    }
}