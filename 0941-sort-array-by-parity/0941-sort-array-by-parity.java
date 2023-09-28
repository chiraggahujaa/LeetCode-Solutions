class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int ind = 0;

        for(int el : nums)
            if(el % 2 == 0)
                res[ind++] = el;

        for(int el : nums)
            if(el % 2 == 1)
                res[ind++] = el;

        return res;
    }
}