class Solution {
    final int mod = 1000000007;
    public int distinctSubseqII(String s) {
        // s -> "caab"
        // [0,0,0,0,0,.....,0]
        // [0,0,1,0,0,.....,0] <-- c char added
        // [2,0,1,0,0,.....,0] <-- a char added
        // [4,0,1,0,0,.....,0] <-- a char added
        // [4,6,1,0,0,.....,0] <-- b char added


        int n = s.length();
        int[] endsWith = new int[26];
        for(char ch : s.toCharArray())
            endsWith[ch-'a'] = (1 + sum(endsWith)) % mod;

        return sum(endsWith) % mod;
    }
    public int sum(int[] arr){
        int tot = 0;
        for(int el : arr)
            tot = (tot + el) % mod;
        return tot;
    }
}