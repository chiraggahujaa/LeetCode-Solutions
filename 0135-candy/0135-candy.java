class Solution {
    public int candy(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        Arrays.fill(res, 1);

        for(int i=1; i<n; i++)
            if(nums[i] > nums[i-1] && res[i] <= res[i-1])
                res[i] = res[i-1] + 1;
        
        for(int i=n-2; i>=0; i--)
            if(nums[i] > nums[i+1] && res[i] <= res[i+1])
                res[i] = res[i+1] + 1;
            
        int tot = 0;
        for(int el : res)
            tot += el;
        
        return tot;
    }
}