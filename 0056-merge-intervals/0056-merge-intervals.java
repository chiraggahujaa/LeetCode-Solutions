class Solution {
    public int[][] merge(int[][] intervals) {
        // [a,b] [c,d]
        // [1,5] [2,3] -> [1,5]
        // [1,3] [2,4] -> [1,4]
        // [a, max(b,d)]

        // b < c then do nothing
        
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1; i<n; i++){
            int a = list.get(list.size()-1)[0], b = list.get(list.size()-1)[1], c = intervals[i][0], d = intervals[i][1];

            if(b < c){
                list.add(intervals[i]);
                continue;
            }
            
            list.remove(list.size()-1);
            list.add(new int[]{a, Math.max(b,d)});
        }

        int len = list.size();
        int[][] res = new int[len][2];
        for(int i=0; i<len; i++)
            res[i] = list.get(i);
        
        return res;            
    }
}