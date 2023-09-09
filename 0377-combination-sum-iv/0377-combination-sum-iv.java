class Solution {
    int n, target;
    HashMap<Integer, Integer> dp;
    public int combinationSum4(int[] nums, int target) {
        this.n = nums.length;
        this.target = target;
        this.dp = new HashMap<>();
        
        return f(0, nums);
    }
    public int f(int sum, int[] nums){
        if(sum == target)
            return 1;
        if(sum > target)
            return 0;

        if(dp.containsKey(sum))
            return dp.get(sum);

        int res = 0;
        for(int j=0; j<n; j++){
            res += f(sum + nums[j], nums);
        }

        dp.put(sum, res);
        return res;
    }
}