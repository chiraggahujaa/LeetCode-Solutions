class Solution {
    int n, m;
    int[][] moves;
    public void solve(char[][] board) {
        this.n = board.length;
        this.m = board[0].length;
        this.moves = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

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

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'T')
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
    private boolean isValid(int i, int j){
        return i>=0 && j>=0 && i<n && j<m;
    }
}