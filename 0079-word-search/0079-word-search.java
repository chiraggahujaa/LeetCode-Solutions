class Solution {
    int n, m;
    int[][] moves;
    boolean[][] vis;
    public boolean exist(char[][] board, String word) {
        this.n = board.length;
        this.m = board[0].length;
        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0) && f(1, i, j, board, word))
                    return true;
            }
        }

        return false;
    }
    public boolean f(int ind, int i, int j, char[][] board, String word){
        if(ind == word.length())
            return true;
        
        vis[i][j] = true;

        for(int[] moveTo : moves){
            int ii = i + moveTo[0];
            int jj = j + moveTo[1];

            if(isValid(ii, jj) && !vis[ii][jj] && board[ii][jj] == word.charAt(ind)){
                if(f(ind+1, ii, jj, board, word))
                    return true;
            }
        }

        vis[i][j] = false;
        return false;
    }
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}