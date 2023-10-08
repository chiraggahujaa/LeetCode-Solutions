class Solution {
    int n1, n2;
    public boolean isMatch(String s, String p) {
        // O(n^2) Approch
        // "*" -> f(i+1, j) or f(i+1, j+1)
        // "?" -> f(i+1, j+1)
        // "aab", "c*a*b" -> c!=a -> false

        this.n1 = s.length();
        this.n2 = p.length();

        int[][] dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, s, p, dp); 
    }
    public boolean f(int i, int j, String s, String p, int[][] dp){
        if(i == n1){
            while(j < n2 && p.charAt(j) == '*')
                j++;
            return j == n2;
        }
        if(j >= n2)
            return false;

        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean res = false;
        if(p.charAt(j) == '*')
            res = f(i, j+1, s, p, dp) || f(i+1, j, s, p, dp);
        else if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
            res = f(i+1, j+1, s, p, dp);

        dp[i][j] = (res ? 1 : 0);
        return res;
    }
}