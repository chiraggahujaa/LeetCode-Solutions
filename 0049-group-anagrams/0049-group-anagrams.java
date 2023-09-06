class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            char[] strArr = strs[i].toCharArray();
            Arrays.sort(strArr);

            String str = new String(strArr);
            map.computeIfAbsent(str, y -> new ArrayList<>()).add(i);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> e : map.entrySet()){
            List<String> list = new ArrayList<>();
            for(int ind : e.getValue()){
                list.add(strs[ind]);
            }

            res.add(list);
        }

        return res;
    }
}