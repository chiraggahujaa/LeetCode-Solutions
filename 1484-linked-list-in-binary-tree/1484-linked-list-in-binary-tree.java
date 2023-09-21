class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null)
            return true;
        if(root == null)
            return false;

        if(root.val == head.val)
            if(f(root, head))
                return true;
                
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }
    public boolean f(TreeNode root, ListNode head){
        if(head == null)
            return true;
        if(root == null || root.val != head.val)
            return false;
        
        return f(root.left, head.next) || f(root.right, head.next);
    }
}