class Solution {
    List<List<Integer>> res;
    int n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new ArrayList<>();
        this.n = nums.length;

        Arrays.sort(nums);

        f(0, nums, new ArrayList<>());
        return res;
    }
    public void f(int i, int[] nums, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int j=i; j<n; j++){
            if(j>i && nums[j] == nums[j-1])
                continue;
            
            list.add(nums[j]);
            f(j+1, nums, list);
            list.remove(list.size()-1);
        }
    }
}