class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);

        for(int k=0; k<n; k++){
            if(k>0 && nums[k] == nums[k-1])
                continue;

            int i=k+1, j = n-1;
            while(i < j){
                if(nums[i] + nums[j] + nums[k] == 0){
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while(i<j && nums[i] == nums[i+1])
                        i++;
                    while(i<j && nums[j] == nums[j-1])
                        j--;
                    i++; j--;
                }
                else if(nums[i] + nums[j] + nums[k] < 0)
                    i++;
                else
                    j--;
            }
        }

        return res;
    }
}