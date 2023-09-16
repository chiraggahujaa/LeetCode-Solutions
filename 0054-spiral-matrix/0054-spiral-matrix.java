class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int left=0, right=m-1, up=0, down=n-1;

        int flag = 0;
        while(left<=right && up<=down){
            if(flag == 0){
                for(int i=left; i<=right; i++)
                    res.add(matrix[up][i]);
                
                up++;
                flag = (flag+1) % 4;
            }
            else if(flag == 1){
                for(int i=up; i<=down; i++)
                    res.add(matrix[i][right]);
                
                right--;
                flag = (flag+1) % 4;
            }
            else if(flag == 2){
                for(int i=right; i>=left; i--)
                    res.add(matrix[down][i]);

                down--;
                flag = (flag+1) % 4;
            }
            else{
                for(int i=down; i>=up; i--)
                    res.add(matrix[i][left]);
                
                left++;
                flag = (flag+1) % 4;
            }
        }

        return res;
    }
}