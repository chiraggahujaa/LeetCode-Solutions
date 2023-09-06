class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            int el = nums[i];
            if(map.containsKey(target - el))
                return new int[]{map.get(target - el), i};
            map.put(el, i);
        }

        return new int[]{-1, -1};
    }
}