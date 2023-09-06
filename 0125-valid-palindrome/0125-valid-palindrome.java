class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder str = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
                str.append(ch);
        }

        return checkPalindrome(str.toString());
    }
    public boolean checkPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}