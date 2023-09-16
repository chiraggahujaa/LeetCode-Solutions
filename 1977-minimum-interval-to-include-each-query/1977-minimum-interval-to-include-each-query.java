class Pair{
    int i, val;
    Pair(int i, int val){
        this.i = i;
        this.val = val;
    }
    public String toString(){
        return "("+ i + " " + val +")";
    }
}
class Solution {
    public int[] minInterval(int[][] intervals, int[] oldQueries) {
        int n = intervals.length, q = oldQueries.length;

        Pair[] queries = new Pair[q];
        for(int i=0; i<q; i++)
            queries[i] = new Pair(i, oldQueries[i]);

        Arrays.sort(intervals, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        Arrays.sort(queries, (a,b) -> a.val==b.val ? a.i-b.i : a.val-b.val);

        // for(int[] row : intervals)
        //     System.out.print(Arrays.toString(row) + " ");

        // System.out.println();
        // System.out.println(Arrays.toString(queries));

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                int aSize = intervals[a][1] - intervals[a][0] + 1;
                int bSize = intervals[b][1] - intervals[b][0] + 1;

                return aSize - bSize;
            }
        );

        int ind = 0;
        int[] res = new int[q];
        for(int i=0; i<q; i++){
            Pair p = queries[i];
            int qI = p.i, val = p.val;

            while(!pq.isEmpty() && (intervals[pq.peek()][0] > val || intervals[pq.peek()][1] < val)){
                pq.poll();
            }

            while(ind < n){
                if(intervals[ind][0] <= val && intervals[ind][1] >= val)
                    pq.offer(ind++);
                else if(intervals[ind][1] <= val)
                    ind++;
                else
                    break;
            }

            if(pq.isEmpty())
                res[qI] = -1;
            else
                res[qI] = intervals[pq.peek()][1] - intervals[pq.peek()][0] + 1;

            // System.out.println(pq);
        }

        return res;
    }
}