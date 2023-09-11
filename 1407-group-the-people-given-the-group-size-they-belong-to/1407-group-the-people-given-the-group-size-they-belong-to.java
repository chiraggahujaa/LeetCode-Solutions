class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++)
            map.computeIfAbsent(groupSizes[i], x->new ArrayList<>()).add(i);
        
        List<List<Integer>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> e : map.entrySet()){
            int sz = e.getKey();
            List<Integer> list = e.getValue();
 
            int i=0;
            while(i < list.size()){
                List<Integer> temp = new ArrayList<>();
                for(int j=0; j<sz; j++){
                    int ind = i+j;
                    temp.add(list.get(ind));
                }
                res.add(temp);
                i += sz;
            }
        }

        return res;
    }
}