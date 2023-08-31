class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] startEnd = new int[n+1];
        for(int i=0; i<=n; i++){
            int start = Math.max(i - ranges[i], 0);
            int end = Math.min(i + ranges[i], n);

            startEnd[start] = Math.max(startEnd[start], end);
        }

        int maxEnd = 0, taps = 0, currEnd = 0;
        for(int i=0; i<=n; i++){
            if(maxEnd < i)
                return -1;

            if(currEnd < i){
                taps++;
                currEnd = maxEnd;
            }

            maxEnd = Math.max(maxEnd, startEnd[i]);
        }

        return taps;
    }
}