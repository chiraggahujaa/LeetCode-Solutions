class Solution {
    int n = 9;
    public boolean isValidSudoku(char[][] board) {
        boolean row = checkForRow(board);
        boolean col = checkForCol(board);
        boolean box = checkForBox(board);

        return row && col && box;
    }
    public boolean checkForRow(char[][] board){
        for(int i=0; i<n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0; j<n; j++){
                char ch = board[i][j];
                if(ch == '.')
                    continue;
                if(set.contains(ch))
                    return false;
                set.add(ch);
            }
        }
        return true;
    }
    public boolean checkForCol(char[][] board){
        for(int j=0; j<n; j++){
            HashSet<Character> set = new HashSet<>();
            for(int i=0; i<n; i++){
                char ch = board[i][j];
                if(ch == '.')
                    continue;
                if(set.contains(ch))
                    return false;
                set.add(ch);
            }
        }
        return true;
    }
    public boolean checkForBox(char[][] board){
        for(int boxI = 0; boxI < 3; boxI++){
            for(int boxJ = 0; boxJ < 3; boxJ++){
                HashSet<Character> set = new HashSet<>();
                int x = boxI*3, y = boxJ*3;
                for(int i = x; i<x+3; i++){
                    for(int j = y; j<y+3; j++){
                        char ch = board[i][j];
                        if(ch == '.')
                            continue;
                        if(set.contains(ch))
                            return false;
                        set.add(ch);
                    }
                }
            }
        }

        return true;
    }
}