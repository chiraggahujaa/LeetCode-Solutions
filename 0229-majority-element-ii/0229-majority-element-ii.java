class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int el : nums)
            map.put(el, map.getOrDefault(el, 0)+1);

        int reqLen = n/3;
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int freq = e.getValue();
            if(freq > reqLen)
                list.add(e.getKey());
        }

        return list;
    }
}