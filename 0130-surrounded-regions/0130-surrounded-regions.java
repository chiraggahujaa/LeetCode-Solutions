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

        // traverse through the border and run dfs on the cell with value 'O' and make all these cells to 'T'.
        for(int i=0; i<n; i++){
            if(board[i][0] == 'O')
                dfs(i, 0, board);
            if(board[i][m-1] == 'O')
                dfs(i, m-1, board);
        }
        for(int j=0; j<m; j++){
            if(board[0][j] == 'O')
                dfs(0, j, board);
            if(board[n-1][j] == 'O')
                dfs(n-1, j, board);
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
    public void dfs(int i, int j, char[][] board){
        board[i][j] = 'T';

        for(int[] moveTo : moves){
            int ii = i + moveTo[0];
            int jj = j + moveTo[1];

            if(isValid(ii, jj) && board[ii][jj] == 'O')
                dfs(ii, jj, board);
        }
    }
    public boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}