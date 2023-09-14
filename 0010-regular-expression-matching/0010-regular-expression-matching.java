class Solution {
    int n1, n2;
    int[][] dp;
    public boolean isMatch(String s, String p) {
        this.n1 = s.length();
        this.n2 = p.length();
        this.dp = new int[n1][n2];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, s, p);
    }
    public boolean f(int i, int j, String s, String p){
        if(i == n1){
            if(j >= n2)
                return true;
            
            while(j < n2){
                boolean nextStar = j+1<n2 && p.charAt(j+1) == '*';
                if(nextStar)
                    j+=2;
                else
                    return false;
            }
            return true;
        }

        if(j >= n2)
            return false;

        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        char ch1 = s.charAt(i);
        char ch2 = p.charAt(j);

        boolean nextStar = j+1<n2 && p.charAt(j+1) == '*';

        if(nextStar){
            if(f(i, j+2, s, p)){
                dp[i][j] = 1;
                return true;
            }
            
            for(int k=i; k<n1; k++){
                if(ch2 == '.' || s.charAt(k) == ch2){
                    if(f(k+1, j+2, s, p)){
                        dp[i][j] = 1;
                        return true;
                    }
                }
                else
                    break;
            }
        }
        else{
            boolean match = (ch2 == '.') || (ch1 == ch2);
            if(match && f(i+1, j+1, s, p)){
                dp[i][j] = 1;
                return true;
            }
        }

        dp[i][j] = 0;
        return false;
    }
}