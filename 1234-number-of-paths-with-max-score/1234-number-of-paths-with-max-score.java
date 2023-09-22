class Solution {
    int n;
    int[] sumCount;
    int[][] moves;
    final static int mod = 1000000007;
    public int[] pathsWithMaxScore(List<String> board) {
        HashMap<String, int[]> dp = new HashMap<>();
        this.n = board.size();
        this.moves = new int[][]{{0,-1},{-1,0},{-1,-1}};
        this.sumCount = new int[200];

        int[] res = f(n-1, n-1, board, dp);

        if(res[0] == Integer.MIN_VALUE)
            return new int[2];
        
        return res;
    }
    public int[] f(int i, int j, List<String> board, HashMap<String, int[]> dp){
        if(i == 0 && j == 0)
            return new int[]{0, 1};
        if(i<0 || j<0 || board.get(i).charAt(j) == 'X')
            return new int[]{Integer.MIN_VALUE, 0};

        String key = i + " " + j;
        if(dp.containsKey(key))
            return dp.get(key);

        char ch = board.get(i).charAt(j);
        int sum = 0, max = 0, count = 0;
        if(ch != 'S')
            sum = (int)(ch - '0');
            
        int[] up = f(i-1, j, board, dp);
        int[] left = f(i, j-1, board, dp);
        int[] upLeft = f(i-1, j-1, board, dp);

        int a = up[0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : (sum + up[0]) % mod;
        int b = left[0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : (sum + left[0]) % mod;
        int c = upLeft[0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : (sum + upLeft[0]) % mod;

        int res = Math.max(a, Math.max(b, c));

        if(a == res) count = (count + up[1]) % mod;
        if(b == res) count = (count + left[1]) % mod;
        if(c == res) count = (count + upLeft[1]) % mod;

        int[] resArr = new int[]{res, count};
        
        dp.put(key, resArr);
        return resArr;
    }
}