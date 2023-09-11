class Solution {
    int n, m;
    boolean isPac, isAtl;
    int[][] moves;
    public List<List<Integer>> pacificAtlantic(int[][] nums) {
        this.n = nums.length;
        this.m = nums[0].length;
        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                this.isPac = false;
                this.isAtl = false;

                dfs(i, j, new boolean[n][m], nums);

                if(isPac && isAtl)
                    res.add(Arrays.asList(i, j));
            }
        }

        return res;
    }
    public void dfs(int i, int j, boolean[][] vis, int[][] nums){
        vis[i][j] = true;

        for(int[] moveTo : moves){
            int ii = i + moveTo[0];
            int jj = j + moveTo[1];

            if(ii < 0 || jj < 0){
                isPac = true;
                continue;
            }

            if(ii >= n || jj >= m){
                isAtl = true;
                continue;
            }

            if(!vis[ii][jj] && nums[ii][jj] <= nums[i][j]){
                dfs(ii, jj, vis, nums);
            }
        }
    }
}