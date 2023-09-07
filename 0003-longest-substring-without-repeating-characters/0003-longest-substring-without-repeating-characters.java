class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), j=0, res = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(set.contains(ch)){
                while(s.charAt(j) != ch){
                    set.remove(s.charAt(j));
                    j++;
                }
                set.remove(s.charAt(j));
                j++;
            }

            set.add(ch);
            res = Math.max(res, set.size());
        }

        return res;
    }
}