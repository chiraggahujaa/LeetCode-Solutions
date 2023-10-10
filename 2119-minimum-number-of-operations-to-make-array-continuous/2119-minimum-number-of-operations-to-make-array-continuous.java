class Solution {
    public int minOperations(int[] nums) {
        // brute force

        // take every element as minEl
        // range = [minEl, minEl + n - 1]
        // if a element is not in the range then operation++
        // maintain set to check for duplicacy

        // optimal -- sort the array
        // take every element as min element
        // we know that all elements before this are out of range for sure, so we just have to check how many elements are greater than maxRange
        // note -> the first value which is > maxRange, after this (inclucding this) value will be > maxRange.
        // so apply binary search to find the next greater element to maxEl.

        int n = nums.length, minOp = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int el : nums)
            set.add(el);
        for(int el : set)
            list.add(el);

        Collections.sort(list);
        
        for(int j=0; j<list.size(); j++){
            int min = list.get(j);
            int max = min + n - 1;

            int op = 0;

            int ind = Collections.binarySearch(list, max+1);
            // System.out.println(min + " " + (max+1) + " " + ind);

            if(ind < 0)
                ind = -ind - 1;
            
            int inRange = (ind - j);
            op = n - inRange;

            minOp = Math.min(minOp, op);
        }

        return minOp;
    }
}