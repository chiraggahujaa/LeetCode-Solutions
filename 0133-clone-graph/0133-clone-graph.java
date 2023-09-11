/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node root) {
        this.map = new HashMap<>();
        if(root == null)
            return null;

        Queue<Node> q = new ArrayDeque<>();
        Set<Node> vis = new HashSet<>();
        
        q.offer(root);
        vis.add(root);

        while(!q.isEmpty()){
            Node node = q.poll();
            List<Node> ngb = node.neighbors;

            Node cloneNode = getNode(node);

            List<Node> cloneNgb = new ArrayList<>();
            for(Node n1 : ngb){
                Node n2 = getNode(n1);
                cloneNgb.add(n2);

                if(!vis.contains(n1)){
                    q.offer(n1);
                    vis.add(n1);
                }
            }
            cloneNode.neighbors = cloneNgb;
        }

        return map.get(root);
    }
    private Node getNode(Node node){
        Node res = null;
        if(map.containsKey(node))
            res = map.get(node);
        else{
            res = new Node(node.val);
            map.put(node, res);
        }
        return res;
    }
}