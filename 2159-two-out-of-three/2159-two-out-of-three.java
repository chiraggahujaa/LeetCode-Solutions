class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> res = new HashSet<>();

        HashSet<Integer> set = new HashSet<>();

        for(int el : nums1)
            set.add(el);
        
        for(int el : nums2)
            if(set.contains(el))
                res.add(el);
        
        for(int el : nums2)
            set.add(el);
        
        for(int el : nums3)
            if(set.contains(el))
                res.add(el);

        List<Integer> list = new ArrayList<>();
        for(int el : res)
            list.add(el);

        return list;
    }
}