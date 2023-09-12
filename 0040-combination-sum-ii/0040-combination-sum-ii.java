class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        this.res = new ArrayList<>();
        this.n = nums.length;

        Arrays.sort(nums);

        f(0, target, nums, new ArrayList<>());
        return res;
    }
    public void f(int i, int k, int[] nums, List<Integer> list){
        if(k == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i >= n && k<0){
            return;
        }

        for(int j=i; j<n; j++){
            if(j>i && nums[j] == nums[j-1])
                continue;

            if(k-nums[j] < 0)
                continue;
            
            list.add(nums[j]);
            f(j+1, k-nums[j], nums, list);
            list.remove(list.size()-1);
        }
    }
}