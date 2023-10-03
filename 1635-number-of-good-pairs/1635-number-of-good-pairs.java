class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        
        int count = 0;
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int val = e.getValue();

            if(val >= 2){
                count += val*(val-1)/2;
            }
        }
        return count;
    }
}