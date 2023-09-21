class Solution {
    HashMap<String, Integer> dp;
    public int longestZigZag(TreeNode root) {
        this.dp = new HashMap<>();

        return f(root, -1) - 1;
    }
    public int f(TreeNode root, int dir){ // dir -> left : 0, right : 1
        if(root == null)
            return 0;

        String key = root + " " + dir;
        if(dp.containsKey(key))
            return dp.get(key);

        int res = 0;
        if(dir == -1){
            int leftAfterStart = 1 + f(root.left, 1);
            int rightAfterStart = 1 + f(root.right, 0);

            int leftWithoutStarting = f(root.left, dir);
            int rightWithoutStarting = f(root.right, dir);

            res = Math.max(Math.max(leftWithoutStarting, rightWithoutStarting), Math.max(leftAfterStart, rightAfterStart));
        }
        else if(dir == 0)
            res = 1 + f(root.left, 1);
        else
            res = 1 + f(root.right, 0);

        dp.put(key, res);
        return res;
    }
}