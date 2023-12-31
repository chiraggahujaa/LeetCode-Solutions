/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        return preOrder(root, "");
    }
    public String preOrder(TreeNode root, String str){
        if(root == null)
            return str;
        
        char rootCh = (char)(root.val + 'a');

        String left = preOrder(root.left, rootCh + str);
        String right = preOrder(root.right, rootCh + str);

        if(root.right == null && root.left == null)
            return rootCh + str;
        if(root.left == null)
            return right;
        if(root.right == null)
            return left;

        if(left.compareTo(right) < 0)
            return left;
        else
            return right;
    }
}