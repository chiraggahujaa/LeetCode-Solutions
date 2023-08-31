class Solution {
    public int lengthOfLongestSubstring(String str) {
        HashMap<Character,Integer> hMap = new HashMap<>();
        int l=0, res=0,i=0,r=0;
        for(i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(hMap.containsKey(ch)){
                l = Math.max(l,hMap.get(ch)+1);
                hMap.remove(ch);
            }
            
            hMap.put(ch,i);
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}