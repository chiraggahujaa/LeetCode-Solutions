class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

        int prevEnd = intervals[0][1], count = 0;
        for(int i=1; i<n; i++){
            int start = intervals[i][0], end = intervals[i][1];

            if(start < prevEnd){ // isOverlapping
                if(end < prevEnd)
                    prevEnd = end;

                count++;
            }
            else
                prevEnd = end;
        }

        return count;
    }
}