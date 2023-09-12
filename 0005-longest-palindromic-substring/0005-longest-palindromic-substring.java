class Solution {
    int n, resLen;
    String res;
    public String longestPalindrome(String s) {
        this.n = s.length();
        this.resLen = 0;
        this.res = "";

        for(int i=0; i<n; i++){
            getMaxSubstring(i, s);

            if(i != n-1)
                getMaxSubstring2(i, s);
        }

        return res;
    }
    public void getMaxSubstring(int i, String s){
        int j = i, k = i;
        while(j>=0 && k<n && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }

        j++;
        k--;

        int len = k-j+1;
        if(resLen < len){
            res = s.substring(j, k+1);
            resLen = len;
        }
    }
    public void getMaxSubstring2(int i, String s){
        int j = i, k = i+1;
        while(j>=0 && k<n && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }

        j++;
        k--;

        int len = k-j+1;
        if(resLen < len){
            res = s.substring(j, k+1);
            resLen = len;
        }
    }
}