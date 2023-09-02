class Solution {
    int n, m;
    int[][] moves;
    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;

        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        // capture surrounded region or we can say : (reverse logic)
        // don't capture unsurrounded region

        // what's unsurrounded region ->
        // every on the borded and everything connected to it for the value 'O'.

        boolean[][] vis = new boolean[n][m];        

        // traverse through the border and run dfs on the cell with value 'O' and make all these cells to 'T'.
        for(int i=0; i<n; i++){
            if(!vis[i][0] && board[i][0] == 'O')
                dfs(i, 0, vis, board);
            if(!vis[i][m-1] && board[i][m-1] == 'O')
                dfs(i, m-1, vis, board);
        }
        for(int j=0; j<m; j++){
            if(!vis[0][j] && board[0][j] == 'O')
                dfs(0, j, vis, board);
            if(!vis[n-1][j] && board[n-1][j] == 'O')
                dfs(n-1, j, vis, board);
        }

        // at end, traverse and make left 'O' to 'X'.
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }
    public void dfs(int i, int j, boolean[][] vis, char[][] board){
        vis[i][j] = true;
        board[i][j] = 'T';

        for(int[] moveTo : moves){
            int ii = i + moveTo[0];
            int jj = j + moveTo[1];

            if(isValid(ii, jj) && !vis[ii][jj] && board[ii][jj] == 'O')
                dfs(ii, jj, vis, board);
        }
    }
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}