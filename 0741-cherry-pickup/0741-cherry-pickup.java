class Solution {
    int n;
    boolean[][] vis;
    int[][] moves;
    HashMap<String, Integer> dp;
    public int cherryPickup(int[][] grid) {
        this.n = grid.length;
        this.vis = new boolean[n][n];
        this.moves = new int[][]{{1,0},{0,1}};
        this.dp = new HashMap<>();

        int res = f(0,0,0,0,grid);

        return res == Integer.MIN_VALUE ? 0 : res;
    }
    public int f(int i, int j, int ii, int jj, int[][] grid){
        if(i == n-1 && j == n-1 && ii == n-1 && jj == n-1)
            return grid[i][j];

        String key = i + " " + j + " " + ii + " " + jj;
        if(dp.containsKey(key))
            return dp.get(key);
        
        vis[i][j] = true;
        vis[ii][jj] = true;

        int count = 0;
        if(i == ii && j == jj)
            count = grid[i][j];
        else
            count = grid[i][j] + grid[ii][jj];

        int max = Integer.MIN_VALUE;
        
        for(int[] moveTo1 : moves){
            for(int[] moveTo2 : moves){
                int newI = i + moveTo1[0], newJ = j + moveTo1[1];
                int newII = ii + moveTo2[0], newJJ = jj + moveTo2[1];

                if(isValid(newI, newJ, grid) && isValid(newII, newJJ, grid))
                    max = Math.max(max, f(newI, newJ, newII, newJJ, grid));
            }
        }

        vis[i][j] = false;
        vis[ii][jj] = false;        

        if(max == Integer.MIN_VALUE){
            dp.put(key, max);
            return max;
        }

        dp.put(key, count + max);
        return count + max;
    }
    private boolean isValid(int i, int j, int[][] grid){
        return i>=0 && j>=0 && i<n && j<n && !vis[i][j] && grid[i][j] != -1;
    }
}