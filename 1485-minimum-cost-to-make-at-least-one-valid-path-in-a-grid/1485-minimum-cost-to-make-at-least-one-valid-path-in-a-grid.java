class Pair{
    int i, j, cost;
    Pair(int i, int j, int cost){
        this.i = i;
        this.j = j;
        this.cost = cost;
    }
}
class Solution {
    int n, m;
    int[][] moves, res;
    public int minCost(int[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;

        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.res = new int[n][m];

        for(int[] row : res)
            Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.cost - b.cost
        );

        pq.offer(new Pair(0,0,0));
        res[0][0] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int i = p.i, j = p.j , cost = p.cost;

            int[] newIJ = getNewIJ(i, j, grid);
            int ii = newIJ[0], jj = newIJ[1];

            if(isValid(ii, jj) && res[ii][jj] > cost){
                res[ii][jj] = cost;
                pq.offer(new Pair(ii, jj, res[ii][jj]));
            }

            for(int[] moveTo : moves){
                ii = i + moveTo[0];
                jj = j + moveTo[1];

                if(ii == newIJ[0] && jj == newIJ[1])
                    continue;

                if(isValid(ii, jj) && res[ii][jj] > cost + 1){
                    res[ii][jj] = cost + 1;
                    pq.offer(new Pair(ii, jj, res[ii][jj]));
                }
            }
        }

        return res[n-1][m-1];
    }
    public int[] getNewIJ(int i, int j, int[][] grid){
        int move = grid[i][j];

        int ii = -1, jj = -1;

        if(move == 1){
            ii = i; jj = j+1;
        }
        else if(move == 2){
            ii = i; jj = j-1;
        }
        else if(move == 3){
            ii = i+1; jj = j;
        }
        else{
            ii = i-1; jj = j;
        }

        return new int[]{ii, jj};
    }
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}