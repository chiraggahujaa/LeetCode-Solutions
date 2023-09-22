class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<String>> map = new HashMap<>();
        for(String word : words)
            map.computeIfAbsent(word.charAt(0), y-> new ArrayList<>()).add(word);

        int count = 0;
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch))
                continue;

            List<String> list = map.remove(ch);
            
            for(int i=0; i<list.size(); i++){
                String str = list.get(i);

                if(str.length() == 1){
                    count++;
                }
                else{
                    String sub = str.substring(1);
                    map.computeIfAbsent(sub.charAt(0), y-> new ArrayList<>()).add(sub);
                }
            }
        }
        
        return count;
    }
}