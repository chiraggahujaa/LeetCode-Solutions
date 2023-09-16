class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }

        for(int ind : row){
            for(int j=0; j<m; j++)
                matrix[ind][j] = 0;
        }

        for(int ind : col)
            for(int i=0; i<n; i++)
                matrix[i][ind] = 0;
    }
}