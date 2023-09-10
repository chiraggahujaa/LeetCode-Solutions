class Node{
    int key, val;
    Node next, prev;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
    public String toString(){
        return key+"";
    }
}
class LRUCache {
    Node head, tail;
    HashMap<Integer, Node> map;
    int len, cap;
    public LRUCache(int capacity) {
        this.map = new HashMap<>();

        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;

        this.len = 0;
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        removeNode(node);
        addToFirst(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            map.remove(node.key);

            Node node2 = new Node(key, value);
            addToFirst(node2);
            map.put(key, node2);
        }
        else{
            Node node = new Node(key, value);

            if(len >= cap){
                Node lastNode = tail.prev;

                map.remove(lastNode.key);
                map.put(key, node);

                removeFromLast();
                addToFirst(node);
            }
            else{
                addToFirst(node);
                map.put(key, node);
                len++;
            }
        }
    }
    private void addToFirst(Node node){
        Node headNext = head.next;

        head.next = node;
        node.prev = head;

        node.next = headNext;
        headNext.prev = node;
    }
    public void removeFromLast(){
        Node node = tail.prev.prev;

        node.next = tail;
        tail.prev = node;
    }
    public void removeNode(Node node){
        Node prevNode = node.prev;

        prevNode.next = node.next;
        node.next.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */