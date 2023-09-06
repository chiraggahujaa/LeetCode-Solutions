/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int ind = 0;

        ListNode curr = head;
        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        int partLen = len/k;
        int extra = len%k;

        curr = head;
        while(curr != null){
            ListNode h = null, t = null;
            for(int i=0; i<partLen; i++){
                if(h == null){
                    h = curr;
                    t = curr;
                }
                else{
                    t.next = curr;
                    t = curr;
                }
                curr = curr.next;
            }
            if(extra > 0){
                if(h == null){
                    h = curr;
                    t = curr;
                }
                else{
                    t.next = curr;
                    t = curr;
                }
                curr = curr.next;
                extra--;
            }

            t.next = null;
            res[ind++] = h;
        }

        return res;
    }
}