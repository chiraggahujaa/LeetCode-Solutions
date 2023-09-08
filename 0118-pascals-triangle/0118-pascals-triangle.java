class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1)));
        
        for(int i=1; i<n; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);

            List<Integer> prevList = res.get(i-1);
            for(int j=1; j<prevList.size(); j++){
                int sum = prevList.get(j-1) + prevList.get(j);
                list.add(sum);
            }

            list.add(1);
            res.add(new ArrayList<>(list));
        }

        return res;
    }
}