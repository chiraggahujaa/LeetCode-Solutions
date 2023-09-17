class Solution {
    int n;
    int[][] dp;
    public int strangePrinter(String s) {
        this.n = s.length();
        this.dp = new int[n][n];

        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, n-1, s);
    }
    public int f(int start, int end, String s){
        if(start == end)
            return 1;
        if(start > end)
            return 0;

        if(dp[start][end] != -1)
            return dp[start][end];

        char ch = s.charAt(start);
        int i=start+1;
        while(i <= end && s.charAt(i) == ch)
            i++;

        int res = 1 + f(i, end, s);
        
        for(int j=i; j<=end; j++){
            if(s.charAt(j) == ch)
                res = Math.min(res, f(i, j-1, s) + f(j, end, s));
        }

        return dp[start][end] = res;
    }
}