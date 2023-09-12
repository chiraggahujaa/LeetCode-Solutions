class Solution {
    int n;
    int[] dp;
    public int numDecodings(String s) {
        this.n = s.length();
        this.dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, s);
    }
    public int f(int i, String s){
        if(i >= n)
            return 1;
        
        if(dp[i] != -1)
            return dp[i];

        int count = 0;
        for(int j=i; j<n; j++){
            String  str = s.substring(i, j+1);
            if(isValid(str))
                count += f(j+1, s);
        }
        return dp[i] = count;
    }
    private boolean isValid(String s){
        if(s.startsWith("0") || s.length() > 2)
            return false;
        
        int num = Integer.parseInt(s);
        return num <= 26;
    }
}