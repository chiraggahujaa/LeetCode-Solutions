class Solution {
    int n1, n2;
    public boolean isMatch(String s, String p) {
        // "aab", "c*a*b" 
        // "c*" can be considered as empty string
        // "aab" "a*b"
        // "a*" can match with any no. of 'a' you want to match -> for loop and try matching till every element
        // "aa" and "a*" matches
        // "b" "b" -- matches
        // true


        this.n1 = s.length();
        this.n2 = p.length();

        int[][] dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0,0,s,p,dp);
    }
    public boolean f(int i, int j, String s, String p, int[][] dp){
        if(i == n1){
            // aab, abb*.*.*.*.*
            while(j<n2-1 && (p.charAt(j) == '*' || p.charAt(j+1) == '*'))
                j+=2;
            return j == n2;
        }
        if(j >= n2 || i>=n1)
            return false;

        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        char ch1 = s.charAt(i), ch2 = p.charAt(j);
        boolean res = false;
        if(j<n2-1 && p.charAt(j+1) == '*'){
            // p.charAt(j) can be repeated any no. of times

            // case 1 - no character matches
            res = res || f(i, j+2, s, p, dp);

            // case 2 - some charcter matches
            while(i < n1 && (s.charAt(i) == ch2 || ch2 == '.')){
                res = res || f(i+1, j+2, s, p, dp);
                i++;
            }
        }
        else if(ch2 == '.' || ch2 == ch1)
            res = res || f(i+1, j+1, s, p, dp);

        if(i<n1)
            dp[i][j] = res ? 1 : 0;
        return res;
    }
}