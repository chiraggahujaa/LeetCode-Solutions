class Solution {
    int n;
    int[][] dp;
    public boolean checkValidString(String s) {
        this.n = s.length();
        this.dp = new int[n][n];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, s);
    }
    public boolean f(int i, int size, String s){
        if(size < 0)
            return false;
        if(i >=n)
            return size == 0;

        if(dp[i][size] != -1)
            return dp[i][size] == 1;

        char ch = s.charAt(i);
        boolean res = false;
        if(ch == '(')
            res = f(i+1, size+1, s);
        else if(ch == ')')
            res = f(i+1, size-1, s);
        else
            res = (f(i+1, size, s) || f(i+1, size+1, s) || f(i+1, size-1, s));

        dp[i][size] = res ? 1 : 0;
        return res;
    }
}