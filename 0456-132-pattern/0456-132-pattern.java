class Pair{
    int val, min;
    Pair(int val, int min){
        this.val = val;
        this.min = min;
    }
    public String toString(){
        return "("+val+" "+min+")";
    }
}
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Pair> st = new Stack<>();
        int min = Integer.MAX_VALUE;

        for(int el : nums){
            while(!st.isEmpty() && st.peek().val <= el)
                st.pop();

            if(!st.isEmpty() && st.peek().min < el)
                return true;
            
            st.push(new Pair(el, min));
            min = Math.min(min, el);            
        }

        return false;
    }
}