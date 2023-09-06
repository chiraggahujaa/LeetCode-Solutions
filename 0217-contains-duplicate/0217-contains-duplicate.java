class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int el : nums){
            if(set.contains(el))
                return true;
            set.add(el);
        }

        return false;
    }
}