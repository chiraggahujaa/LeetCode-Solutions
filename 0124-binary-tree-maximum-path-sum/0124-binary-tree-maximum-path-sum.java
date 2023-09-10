class Solution {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        f(root);
        return res;
    }
    public int f(TreeNode root){
        if(root == null)
            return 0;

        int l = f(root.left);
        int r = f(root.right);

        res = Math.max(Math.max(res, root.val + l + r), Math.max(Math.max(root.val + l, root.val + r), root.val));
        return Math.max(root.val + Math.max(l, r), root.val);
    }
}