class Pair{
    int val, minLeft;
    Pair(int val, int minLeft){
        this.val = val;
        this.minLeft = minLeft;
    }
}
class Solution {
    public boolean find132pattern(int[] nums) {
        // Approch -> Monotonic Stack

        // Not intuitive, have to maintain k index rather than j
        // nums[i] < nums[k] < nums[j] -> this way we need a jth value which is greater than kth val
        // also, an ith value which is minimum value till now
        // if that constrain is satisfied then return true

        // How to maintain k val -> we have to maintain monotonically decresing stack,
        // 1. if stack size is greater than or equals to 1, that means for current index k, there exist a greater value that came before.
        // 2. we also have to keep track of min value till now (excluding current obv).
        // 3. then we just need to satisfy that constrain

        int n = nums.length;
        Stack<Pair> st = new Stack<>();
        int min = Integer.MAX_VALUE;

        for(int k=0; k<n; k++){
            while(!st.isEmpty() && st.peek().val <= nums[k])
                st.pop();

            if(st.size() >= 1){
                if(nums[k] > st.peek().minLeft)
                    return true;
            }

            st.push(new Pair(nums[k], min));
            min = Math.min(min, nums[k]);     
        }

        return false;
    }
}