class Solution {
    int n1, n2;
    String s,t;
    int[][] dp;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        
        this.n1 = s.length();
        this.n2 = t.length();

        this.dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0,0);
    }
    public int f(int i, int j){
        if(j == n2)
            return 1;
        if(i >= n1)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int res = 0;
        if(s.charAt(i) == t.charAt(j)){
            res = f(i+1, j+1) + f(i+1, j);
        }
        else{
            res = f(i+1, j);
        }

        return dp[i][j] = res;
    }
}