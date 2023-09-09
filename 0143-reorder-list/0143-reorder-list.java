class Solution {
    public void reorderList(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<>();
        ListNode curr = head, prev = null;
        while(curr != null){
            map.put(curr, prev);

            prev = curr;
            curr = curr.next;
        }

        ListNode n1 = head, n2 = prev;
        boolean flag = true;
        while(n1 != n2){
            if(flag){
                ListNode temp = n1.next;
                n1.next = n2;
                n1 = temp;
                flag = !flag;
            }else{
                n2.next = n1;
                n2 = map.get(n2);
                flag = !flag;
            }
        }

        n1.next = null;
    }
}