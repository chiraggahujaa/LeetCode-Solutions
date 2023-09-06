class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);

            String str = new String(strArr);
            map.computeIfAbsent(str, y -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}