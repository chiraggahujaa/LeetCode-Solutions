class Solution {
    public int getSum(int a, int b) {
        int res = 0, carry = 0;

        for(int i=0; i<32; i++){
            int aBit = a>>i & 1;
            int bBit = b>>i & 1;

            int val = carry ^ aBit ^ bBit;
            res |= val << i;

            if((carry & 1) == 1)
                carry = aBit | bBit;
            else
                carry = aBit & bBit;
        }

        return res;
    }
}