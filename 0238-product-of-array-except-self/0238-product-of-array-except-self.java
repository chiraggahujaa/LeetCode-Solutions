class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int noOfZero = 0;
        int zeroInd = -1;

        int mul = 1;
        for(int i=0; i<n; i++){
            int el = nums[i];
            if(el == 0){
                noOfZero++;
                zeroInd = i;
            }
            else
                mul *= el;
        }

        if(noOfZero >= 2)
            return res;

        if(noOfZero == 1){
            res[zeroInd] = mul;
            return res;
        }

        for(int i=0; i<n; i++){
            res[i] = mul / nums[i];
        }

        return res;
    }
}