class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // at every position you have 2 option -> go to the left or to the right -- dp (that too hard to implement) - O(n^2)
        // need of a greedy solution -- O(n)
        // only position to consider [start-k, start+k]

        // startPos = 9, k = 7
        // right = (k - left)/2
        // left = 7, right = 0 -- [2,3,4,5,6,7,8,9]
        // left = 6, right = 0 -- [3,4,5,6,7,8,9]
        // left = 5, right = 1 -- [4,5,6,7,8,9,10]
        // left = 4, right = 1 -- [5,6,7,8,9,10]
        // left = 3, right = 2 -- [6,7,8,9,10,11]
        // left = 2, right = 2 -- [7,8,9,10,11]
        // left = 1, right = 3 -- [8,9,10,11,12]
        // left = 0, right = 3 -- [9,10,11,12]

        // -- sum of [startPos - left, startPos] + sum of [startPos, startPos + right]

        // now do the same with the right
        // -- sum of [startPos - left, startPos] + sum of [startPos, startPos + right]

        // Fruits map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] fruit : fruits)
            map.put(fruit[0], fruit[1]);
        
        // preSum computation
        HashMap<Integer, Integer> preSum = new HashMap<>();
        int i = Math.max(startPos - k, 0);

        preSum.put(i, map.getOrDefault(i, 0));
        i++;

        while(i <= startPos + k){
            int temp = map.getOrDefault(i, 0);
            preSum.put(i, temp + preSum.get(i-1));

            i++;
        }
        // System.out.println(preSum);
        
        int res = 0;

        // left
        for(int left = 0; left <=k; left++){
            int right = (k - left)/2;

            int lSum = preSum.getOrDefault(startPos, 0) - preSum.getOrDefault(startPos - left - 1, 0);
            int rSum = preSum.getOrDefault(startPos + right, 0) - preSum.getOrDefault(startPos - 1, 0);

            int sum = lSum + rSum;
            // if(right != 0)
                sum -= map.getOrDefault(startPos, 0);
            
            res = Math.max(sum, res);
        }

        // right
        for(int right = 0; right <= k; right++){
            int left = (k - right)/2;

            int lSum = preSum.getOrDefault(startPos, 0) - preSum.getOrDefault(startPos - left - 1, 0);
            int rSum = preSum.getOrDefault(startPos + right, 0) - preSum.getOrDefault(startPos - 1, 0);

            // if both sides motion -- then the middle should be considered only once
            int sum = lSum + rSum;
            // if(left != 0)
                sum -= map.getOrDefault(startPos, 0);

            // System.out.println(left + " " + right +  " " + sum); // right = 7, left = 4
            res = Math.max(sum, res);
        }

        return res;
    }
}