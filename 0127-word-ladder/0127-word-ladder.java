class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String el : wordList)
            set.add(el);

        if(!set.contains(endWord))
            return 0;

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> vis = new HashSet<>();

        q.offer(beginWord);
        vis.add(beginWord);

        int count = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int x=0; x<sz; x++){
                String s1 = q.poll();
                if(s1.equals(endWord))
                    return count+1;

                char[] str = s1.toCharArray();
                for(int i=0; i<str.length; i++){
                    for(int j=0; j<26; j++){
                        char ch = (char)(j + 'a');

                        char temp = str[i];
                        str[i] = ch;
                        String s = new String(str);

                        if(!vis.contains(s) && set.contains(s)){
                            q.offer(s);
                            vis.add(s);
                        }

                        str[i] = temp;
                    }
                }
            }
            count++;
        }

        return 0;
    }
}