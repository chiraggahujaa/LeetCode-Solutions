class Solution {
    long max = 0, total = 0;
    final int mod = 1000000007;
    public int maxProduct(TreeNode root) {
        this.total = getTotal(root);
        postOrder(root);
        return (int) (max % mod);
    }
    public long postOrder(TreeNode root){
        if(root == null)
            return 0;
        
        long l = postOrder(root.left);
        long r = postOrder(root.right);

        long sum = root.val + l + r;
        long product = (total - sum) * sum;
        max = Math.max(max, product);

        return sum % mod;
    }
    public long getTotal(TreeNode root){
        if(root == null) return 0;
        return root.val + getTotal(root.left) + getTotal(root.right);
    }
}