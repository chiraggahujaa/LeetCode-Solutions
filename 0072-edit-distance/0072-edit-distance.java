class Solution {
    int n1, n2;
    int[][] dp;
    public int minDistance(String s, String t) {
        this.n1 = s.length();
        this.n2 = t.length();

        this.dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, s, t);
    }
    public int f(int i, int j, String s, String t){
        if(i == n1)
            return n2-j;
        if(j == n2)
            return n1-i;

        if(dp[i][j] != -1)
            return dp[i][j];

        int res = 0;
        if(s.charAt(i) == t.charAt(j))
            res = f(i+1, j+1, s, t);
        else{
            int add = 1 + f(i, j+1, s, t);
            int remove = 1 + f(i+1, j, s, t);
            int update = 1 + f(i+1, j+1, s, t);

            res = Math.min(add, Math.min(remove, update));
        }

        return dp[i][j] = res;
    }
}