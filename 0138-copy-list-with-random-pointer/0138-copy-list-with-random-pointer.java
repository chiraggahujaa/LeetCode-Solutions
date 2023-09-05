class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null){
            Node node = new Node(curr.val);
            map.put(curr,node);

            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);

            curr = curr.next;
        }

        return map.get(head);
    }
}