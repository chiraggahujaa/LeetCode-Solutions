class Solution {
    public int majorityElement(int[] nums) {
        // note - there is only 1 majority element
        // why? let's say there are 2 majority elements. that means they have to be greater than n/2.
        // let's say n/2 + 1 count for both the elements
        // for that to be true, the length should be (n/2 + 1) + (n/2 + 1) = n+2, but the length is n.

        // Approch - Moore’s Voting Algorithm
        // we have to choose a contender for the majority element
        // then we will check if that is actually the majority element or not

        // [7,7,5,5,1,7,7,5,5,5,5,5,5,5]
        // i=0 -> cand = 7, count = 1
        // i=1-> cand = 7, count = 2
        // i=2 -> cand = 7, count = 1
        // i=3 -> cand = 7, count = 0
        // count=0 means that in array [7,7,5,5] there is not majority element, they cancel out each other

        // so let's start the search again
        // i=4 -> cand = 1, count = 1
        // i=5 -> cand = 1, count = 0
        // in array [1,7] there is no majority element

        // so let's search again
        // i=6 -> cand = 7, count = 1
        // i=7 -> cand = 7, count = 2
        // i=8 -> cand = 7, count = 1
        // i=9 -> cand = 7, count = 0
        // in array [7,7,5,5] there is no majority element

        // so let's start the search again
        // i=10 -> cand = 5, count = 1
        // i=11 -> cand = 5, count = 2
        // i=12 -> cand = 5, count = 3
        // i=13 -> cand = 5, count = 4
        // i=14 -> cand = 5, count = 5

        // so our candidate is 5
        // now we will check if 5 frequency is actually greater than n/2
        // but since it's given here that there exist a majority element for sure then cand is the majority element.
        
        int n = nums.length;
        int cand = Integer.MIN_VALUE, count = 0;
        for(int el : nums){
            if(count == 0){
                cand = el;
                count = 1;
            }
            else if(cand == el)
                count++;
            else
                count--;
        }

        return cand;
    }
}