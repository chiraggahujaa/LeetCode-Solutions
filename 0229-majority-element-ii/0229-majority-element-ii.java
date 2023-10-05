class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // note - max number of majority element are 2
        // we have to choose 2 contender for the majority elements

        int n = nums.length;
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0;
        for(int el : nums){
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