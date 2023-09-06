class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for(int i=0; i<s.length(); i++){
            int ind1 = s.charAt(i) - 'a';
            int ind2 = t.charAt(i) - 'a';

            ch1[ind1]++;
            ch2[ind2]++;
        }

        for(int i=0; i<26; i++){
            if(ch1[i] != ch2[i])
                return false;
        }

        return true;
    }
}