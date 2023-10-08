class Job{
    int start, end, profit;
    Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}
class Solution {
    int n;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        this.n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0; i<n; i++)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

        Arrays.sort(jobs, (a,b) -> a.start - b.start);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return f(0, jobs, dp);
    }
    public int f(int i, Job[] jobs, int[] dp){
        if(i == n)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        // not take this job
        int notTake = f(i+1, jobs, dp);

        // take this job
        int ind = nextJob(i, jobs); // binary search
        int take = jobs[i].profit + f(ind, jobs, dp);

        return dp[i] = Math.max(take, notTake);
    }
    public int nextJob(int i, Job[] jobs){
        int lo = i+1, hi = n-1;
        int res = n;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(jobs[i].end <= jobs[mid].start){
                res = mid;
                hi = mid-1;
            }
            else
                lo = mid + 1;
        }
        return res;
    }
}