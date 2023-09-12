class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        long res = Integer.MIN_VALUE;

        long pre = 1;
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
                res = Math.max(res, 0);
                pre = 1;
            }
            else{
                pre *= nums[i];
                res = Math.max(res, pre);
            }
        }

        long suff = 1;
        for(int i=n-1; i>=0; i--){
            if(nums[i] == 0){
                res = Math.max(res, 0);
                suff = 1;
            }
            else{
                suff *= nums[i];
                res = Math.max(res, suff);
            }
        }

        return (int)res;
    }
}