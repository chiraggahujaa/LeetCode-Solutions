class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
            
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int count = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int x=0; x<sz; x++){
                TreeNode node = q.poll();
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            count++;
        }

        return count;
    }
}