class Solution {
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int el : nums)
            list.add(el);

        Collections.sort(list, (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0)
                return -1;
            else if (a % 2 != 0 && b % 2 == 0)
                return 1;
            else
                return a - b;
        });

        for(int i=0; i<nums.length; i++)
            nums[i] = list.get(i);

        return nums;
    }
}