class Solution {
    int n;
    public int[][] insert(int[][] intervals, int[] newInterval) {
        this.n = intervals.length;

        // binary search -> find insertion index
        int ind = findInsertionIndex(intervals, newInterval);

        // insert value at it's index
        intervals = insertAtIndex(ind, intervals, newInterval);

        // merge overlapping intervals
        return merge(intervals);
    }
    
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int n = nums.length;
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<n-1; i++){
            int a = nums[i][0], b = nums[i][1], c = nums[i+1][0], d = nums[i+1][1];
            
            if(b >= c){
                nums[i+1][0] = nums[i][0];
                nums[i+1][1] = Math.max(nums[i+1][1], nums[i][1]);
            }
            else{
                list.add(new int[]{nums[i][0], nums[i][1]});
            }
        }
        list.add(new int[]{nums[n-1][0], nums[n-1][1]});

        int[][] res = new int[list.size()][2];
        int ind = 0;
        for(int[] arr : list){
            res[ind++] = arr;
        }

        return res;
    }
    private int findInsertionIndex(int[][] intervals, int[] newInterval){
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = intervals[i][0];

        int ind = Arrays.binarySearch(arr, newInterval[0]);
        if(ind < 0)
            ind = Math.abs(ind) - 1;

        return ind;
    }
    private int[][] insertAtIndex(int ind, int[][] intervals, int[] newInterval){
        int[][] arr = new int[n+1][2];

        for(int i=0; i<ind; i++)
            arr[i] = intervals[i];
        
        arr[ind] = newInterval;

        for(int i=ind+1; i<=n; i++)
            arr[i] = intervals[i-1];
        
        return arr;
    }
}