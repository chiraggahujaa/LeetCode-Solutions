class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);

            String str = new String(strArr);
            map.computeIfAbsent(str, y -> new ArrayList<>()).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> e : map.entrySet()){
            res.add(e.getValue());
        }

        return res;
    }
}