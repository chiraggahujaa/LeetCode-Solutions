class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashSet<Integer> res = new HashSet<>();

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int el : nums1)
            set1.add(el);
        
        for(int el : nums2){
            if(set1.contains(el))
                res.add(el);
            set2.add(el);
        }
        
        for(int el : set2)
            set1.add(el);
        
        for(int el : nums3)
            if(set1.contains(el))
                res.add(el);

        List<Integer> list = new ArrayList<>();
        for(int el : res)
            list.add(el);

        return list;
    }
}