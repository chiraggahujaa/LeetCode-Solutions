class Pair{
    int i, j, diff;
    Pair(int i, int j, int diff){
        this.i = i;
        this.j = j;
        this.diff = diff;
    }
}
class Solution {
    int n, m;
    int[][] moves;
    public int minimumEffortPath(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;

        this.moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.diff - b.diff
        );
        int[][] res = new int[n][m];

        for(int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE);
        pq.offer(new Pair(0,0,0));
        res[0][0] = 0;

        int maxDiff = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i = p.i, j = p.j, diff = p.diff;
            maxDiff = Math.max(maxDiff, diff);

            if(i == n-1 && j == m-1)
                return maxDiff;

            for(int[] moveTo : moves){
                int ii = i + moveTo[0];
                int jj = j + moveTo[1];

                if(!isValid(ii, jj))
                    continue;

                int currDiff = Math.abs(grid[ii][jj] - grid[i][j]);

                if(currDiff < res[ii][jj]){
                    res[ii][jj] = currDiff;
                    pq.offer(new Pair(ii, jj, res[ii][jj]));
                }
            }
        }

        return maxDiff;
    }
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}