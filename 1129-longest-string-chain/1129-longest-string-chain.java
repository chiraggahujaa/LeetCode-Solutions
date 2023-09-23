class Solution {
    int n;
    public int longestStrChain(String[] words) {
        this.n = words.length;
        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return f(0, 0, words, dp);
    }
    public int f(int i, int prev, String[] words, int[][] dp){
        if(i == n)
            return 0;

        if(dp[i][prev] != -1)
            return dp[i][prev];

        int take = 0;
        if(prev == 0 || canTake(words[i], words[prev-1]))
            take = 1 + f(i+1, i+1, words, dp);
        
        int notTake = f(i+1, prev, words, dp);

        return dp[i][prev] = Math.max(take, notTake);
    }
    private boolean canTake(String s, String t){
        int n1 = s.length(), n2 = t.length();

        if(n1 != n2+1)
            return false;

        int i=0, j=0, count=0;
        while(i<n1 && j<n2){
            if(s.charAt(i) != t.charAt(j)){
                count++;
                i++;
            }
            else{
                i++; j++;
            }
            
            if(count > 1)
                return false;
        }

        // abcd, abc -> i=n1-1, count=0
        // abqc, abc -> i=n1, count=1

        return (i==n1-1 && count==0) || (i==n1 && count==1);
    }
}