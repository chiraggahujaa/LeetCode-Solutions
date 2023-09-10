class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int x=0; x<sz; x++){
                TreeNode node = null;
                if(flag)
                    node = q.poll();
                else
                    node = q.poll();

                temp.add(node.val);

                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            if(!flag)
                Collections.reverse(temp);
            flag = !flag;
            res.add(temp);
        }

        return res;
    }
}