class Solution {
    int n, target;
    HashMap<String, Integer> dp;
    public int combinationSum4(int[] nums, int target) {
        this.n = nums.length;
        this.target = target;
        this.dp = new HashMap<>();
        
        return f(0, 0, nums);
    }
    public int f(int i, int sum, int[] nums){
        if(sum == target)
            return 1;
        if(sum > target || i >= n)
            return 0;

        String key = i + " " + sum;
        if(dp.containsKey(key))
            return dp.get(key);

        int take = f(0, sum + nums[i], nums);
        int notTake = f(i+1, sum, nums);

        dp.put(key, take + notTake);
        return take + notTake;
    }
}