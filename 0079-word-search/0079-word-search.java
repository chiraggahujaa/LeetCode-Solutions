class Solution {
    int n, m;
    int[][] moves;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;

        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean[][] vis = new boolean[n][m];
                boolean[][] inRec = new boolean[n][m];
                if(board[i][j] == word.charAt(0))
                    if(dfs(i, j, 1, vis, inRec, board, word))
                        return true;
            }
        }

        return false;
    }
    public boolean dfs(int i, int j, int ind, boolean[][] vis, boolean[][] inRec, char[][] board, String word){
        if(ind == word.length())
            return true;
            
        vis[i][j] = true;

        for(int[] moveTo : moves){
            int ii = i + moveTo[0];
            int jj = j + moveTo[1];

            

            if(isValid(ii, jj)){
                if(!vis[ii][jj] && word.charAt(ind) == board[ii][jj] && dfs(ii, jj, ind+1, vis, inRec, board, word))
                    return true;
            }
        }

        vis[i][j] = false;
        return false;
    }
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}