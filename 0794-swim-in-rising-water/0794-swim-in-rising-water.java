class Pair{
    int i, j, max;
    Pair(int i, int j, int max){
        this.i = i;
        this.j = j;
        this.max = max;
    }
}
class Solution {
    int n;
    int[][] moves;
    public int swimInWater(int[][] grid) {
        this.n = grid.length;
        this.moves = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        PriorityQueue<Pair> pq = new  PriorityQueue<>(
            (a,b) -> a.max - b.max
        );
        int[][] res = new int[n][n];

        for(int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE);

        pq.offer(new Pair(0,0,grid[0][0]));
        res[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i = p.i, j = p.j, max = p.max;

            for(int[] moveTo : moves){
                int ii = i + moveTo[0], jj = j + moveTo[1];

                if(!isValid(ii, jj))
                    continue;

                int val = Math.max(grid[ii][jj], max);
                if(res[ii][jj] > val){
                    res[ii][jj] = val;
                    pq.offer(new Pair(ii, jj, val));
                }
            }
        }

        return res[n-1][n-1];
    }
    public boolean isValid(int i, int j){
        return (i < n && j < n && i>=0 && j>=0);
    }
}