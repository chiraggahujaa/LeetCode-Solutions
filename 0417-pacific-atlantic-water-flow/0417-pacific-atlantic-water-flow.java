class Solution {
    int n, m;
    boolean[][] pac, atl;
    int[][] moves;
    public List<List<Integer>> pacificAtlantic(int[][] nums) {
        // burte force
        this.n = nums.length;
        this.m = nums[0].length;
        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.pac = new boolean[n][m];
        this.atl = new boolean[n][m];

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<n; i++)
            dfs(i, 0, pac, nums);
        for(int j=0; j<m; j++)
            dfs(0, j, pac, nums);
        
        for(int i=0; i<n; i++)
            dfs(i, m-1, atl, nums);
        for(int j=0; j<m; j++)
            dfs(n-1, j, atl, nums);

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pac[i][j] && atl[i][j])
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

            if(ii < 0 || jj < 0 || ii >= n || jj >= m)
                continue;
            
            if(!vis[ii][jj] && nums[ii][jj] >= nums[i][j]){
                dfs(ii, jj, vis, nums);
            }
        }
    }
}