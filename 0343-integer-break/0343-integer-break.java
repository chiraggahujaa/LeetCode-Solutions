class Solution {
    public int integerBreak(int n) {
        // Approch -- greedy 
        // we must note that we will get the maximum product value when we split into sum of 3
        // 12 -- 6*6 = 36 or 4*4*4 = 64 or 3*3*3*3 = 81 => max = 81

        // edge cases (bz must break into 2)
        // only for 2 and 3 the product after breaking is less than their value. that's value we have to handle them diffrently
        // 2 -- 1*1 < 2
        // 3 -- 2*1 < 3

        if(n <= 3)
            return n-1;

        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res*n;
    
    }
}