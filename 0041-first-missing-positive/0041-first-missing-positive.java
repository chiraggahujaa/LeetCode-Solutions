class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int el : nums)
            set.add(el);
        
        int num = 1;
        while(set.contains(num))
            num++;

        return num;
    }
}