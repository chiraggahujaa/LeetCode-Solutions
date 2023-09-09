class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }

        int i = 0, j = list.size()-1;
        ListNode h = null, t = null;
        boolean isEven = true;

        while(i <= j){
            
            ListNode node;
            if(isEven){
                node = list.get(i);
                isEven = !isEven;
                i++;
            }else{
                node = list.get(j);
                isEven = !isEven;
                j--;
            }

            if(h == null){
                h = node;
                t = node;
            }
            else{
                t.next = node;
                t = node;
            }
        }

        t.next = null;
        head = h;
    }
}