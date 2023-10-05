class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // note - max number of majority element are 2
        // we have to choose 2 contender for the majority elements

        // algorithm -- 
        // maintain num1, num2 for condidates and count1, count2 as their count
        // [2,1,1,3,1,4]
        // i=0 -> num1 = 2, count1 = 1
        // i=1 -> num2 = 1, count2 = 1
        // i=2 -> num2 = 1, count2 = 2
        // i=3 -> count1 = 0, count2 = 1
        // so for the array [2,1,1,3], we are sure that 2 is not a contender for majority element
        // i=4 -> num2 = 1, count2 = 2
        // i=5 -> num1 = 4, count1 = 1

        // so we have 2 contenders for majority element -- 1,4
        // now we can check if they are actually the majority element or not

        int n = nums.length;
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        for(int el : nums){
            // the issuse we will face if we will not write el != num2 is that if count1 is 0 and num2 holds the value of el, then techincally count2 should be incremented rather than assigning el to num1.
            if(count1 == 0 && el != num2){
                num1 = el;
                count1 = 1;
            }
            else if(count2 == 0 && el != num1){
                num2 = el;
                count2 = 1;
            }
            else if(num1 == el){
                count1++;
            }
            else if(num2 == el){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        int c1 = 0, c2 = 0;
        for(int el : nums){
            if(el == num1)
                c1++;
            else if(el == num2)
                c2++;
        }

        int reqLen = n/3;
        if(reqLen < c1)
            list.add(num1);
        if(reqLen < c2)
            list.add(num2);

        return list;
    }
}