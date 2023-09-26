// Logic -> Greedy
// [3,1,1,2]

// at i=0, we must need atleast 3 operation
// that operation will be useful to reduce
// [3,1,1,2] -> [2,0,0,1] -> [1,0,0,1] -> [0,0,0,1]

// at i=2 and i=3, we no need any more operation

// at i=4, we must need atleast 1 operation
// that operation will be useful to reduce [0,0,0,1] -> [0,0,0,0]

// If we carefully notice, for each index we need abs(nums[i] - nums[i-1]) operations. (Intially nums[0] operations)
// How? 
// Initally at i=0, 3 is for sure required since to reduce a value 3 to 0, we need atleast 3 operations
// at i=1 and i=2, we require 1-3 = -2 = 0 operations are required => cz they are already reduced by intial operation
// at i=3, we require 2-1 = 1 operation to reduce 1 to 0 at the end.

class Solution {
    public int minNumberOperations(int[] target) {
        int res = target[0];
        for(int i=1; i<target.length; i++)
            res += Math.max(target[i] - target[i-1], 0);
        return res;
    }
}