class Solution {
    int n;
    public int minExtraChar(String s, String[] dict) {
        this.n = s.length();
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, s, dict, dp);
    }
    public int f(int i, String s, String[] dict, int[] dp){
        if(i == n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int take = n;
        for(int j=0; j<dict.length; j++){
            if(s.substring(i).startsWith(dict[j])){
                int wordLen = dict[j].length();
                take = Math.min(take, f(i + wordLen, s, dict, dp));
            }
        }
        int notTake = 1 + f(i+1, s, dict, dp);

        return dp[i] = Math.min(take, notTake);
    }
}