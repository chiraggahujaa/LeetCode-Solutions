class Solution {
    String s1, s2, s3;
    int n1, n2, n3;
    HashMap<String, Boolean> dp; 
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        this.n1 = s1.length();
        this.n2 = s2.length();
        this.n3 = s3.length();

        this.dp = new HashMap<>();
            
        return f(0, 0, 0);
    }
    public boolean f(int i, int j, int k){
        if(k >= n3)
            if(i >= n1 && j >= n2)
                return true;
            else
                return false;
        
        String key = i + " " + j + " " + k;

        if(dp.containsKey(key))
            return dp.get(key);
        
        boolean match1 = i<n1 ? s1.charAt(i) == s3.charAt(k) : false;
        boolean match2 = j<n2 ? s2.charAt(j) == s3.charAt(k) : false;

        boolean res = false;
        if(match1 && match2)
            res = f(i+1, j, k+1) || f(i, j+1, k+1);
        else if(match1)
            res = f(i+1, j, k+1);
        else if(match2)
            res = f(i, j+1, k+1);
        
        dp.put(key, res);
        return res;
    }
}