class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // remove non overlapping
        // maintain prevEnd


        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int n = intervals.length;
        int prevEnd = intervals[0][1], res = 0;

        for(int i=1; i<n; i++){
            int start = intervals[i][0], end = intervals[i][1];

            if(prevEnd > start){ // overlapping
                if(end < prevEnd) // remove the inteval which has large end value and keep the smaller one
                    prevEnd = end;

                res++;
            }
            else
                prevEnd = end;
        }

        return res;
    }
}