class Solution {
    public int firstMissingPositive(int[] nums) {
        // Approch 1 -> sort array. ignore negitives. start checking for missing number.

        // Approch 2 -> store elements in a sest and check for each every positive number, if not found then return that  number.
        // HashSet<Integer> set = new HashSet<>();
        // for(int el : nums)
        //     set.add(el);
        
        // int num = 1;
        // while(set.contains(num))
        //     num++;

        // Approch 3 -> Maintain values in array itself. so no extra space.
        // Fact -> missing no. can't be greater than size of the array. (it's less or equal).
        // so if a num is positive and less than array size, then put it in it's index.
        // at end loop again and check if value is at index.

        // Issue -> {3,4,-1,1}. Here 3 will be placed at i = 3-1 = 2, which will replace -1. To solve that issue we can just swap these indexes rather than changing it's value. Don't increment value when swap.
        // Dont swap and just i++ when value is at correct place.
        // if out of bound then just i++

        int i=0, n=nums.length;
        while(i < n){
            int val = nums[i];

            if(val > n || val<=0)
                i++;
            else if(i == val-1)
                i++;
            else{
                if(nums[val-1] == val)
                    i++;
                else{
                    int temp = nums[i];
                    nums[i] = nums[val-1];
                    nums[val-1] = temp;
                }
                
            }
        }

        System.out.println(Arrays.toString(nums));
        for(i=0; i<n; i++){
            if(nums[i] != i+1)
                return i+1;
        }

        return n+1;
    }
}