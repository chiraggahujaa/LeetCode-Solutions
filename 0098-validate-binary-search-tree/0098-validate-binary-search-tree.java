class Solution {
    public boolean isValidBST(TreeNode root) {
        return f(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
    }
    private boolean f(TreeNode root, long leftRange, long rightRange){
        if(root == null)
            return true;
        
        // System.out.println(root.val + " " + leftRange + " " + rightRange);

        return (long)root.val > leftRange 
            && (long)root.val < rightRange 
            && f(root.left, leftRange, root.val)
            && f(root.right, root.val, rightRange);
    }
}