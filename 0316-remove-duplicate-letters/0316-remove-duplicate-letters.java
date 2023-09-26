class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];

        for(char ch : s.toCharArray())
            freq[ch-'a']++;

        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(vis[ch-'a']){
                freq[ch-'a']--;
                continue;
            }

            while(!st.isEmpty() && st.peek() > ch && freq[st.peek()-'a']>0){
                vis[st.peek()-'a'] = false;
                st.pop();
            }

            st.push(ch);
            vis[ch-'a'] = true;
            freq[st.peek()-'a']--;
        }

        StringBuilder str = new StringBuilder();
        for(char ch : st)
            str.append(ch);

        return str.toString();
    }
}