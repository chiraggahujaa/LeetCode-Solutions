public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0, shift = 0;

        for(int i=31; i>=0; i--){
            int bit = (n>>i) & 1;
            res |= bit << (31-i);
        }

        return res;
    }
}