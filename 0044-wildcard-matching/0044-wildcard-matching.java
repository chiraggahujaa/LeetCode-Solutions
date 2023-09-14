class Solution {
    int n1, n2;
    int[][] dp;
    public boolean isMatch(String s, String t) {
        this.n1 = s.length();
        this.n2 = t.length();

        this.dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, s, t);
    }
    public boolean f(int i, int j, String s, String t){
        if(i == n1){
            if(j == n2)
                return true;
            
            while(j < n2){
                if(t.charAt(j) != '*')
                    return false;
                j++;
            }

            return true;
        }

        if(j == n2)
            return false;

        if(dp[i][j] != -1)
            return dp[i][j] == 1;
        
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(j);

        if(ch2 == '*'){
            for(int k=i; k<=n1; k++){
                if(f(k, j+1, s, t)){
                    dp[i][j] = 1;
                    return true;
                }
            }
        }
        else{
            boolean match = (ch2 == '?') || (ch1 == ch2);
            if(match && f(i+1, j+1, s, t)){
                dp[i][j] = 0;
                return true;
            }
        }
        
        dp[i][j] = 0;
        return false;
    }
}