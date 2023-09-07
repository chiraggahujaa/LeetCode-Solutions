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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            ListNode[] nodes = reverse(head, right - left + 1);
            head.next = nodes[0];
            return nodes[1];
        }
        else{
            ListNode curr = head;
            for(int i=0; i<left-2; i++){ // runs for left-2 times
                curr = curr.next;
            }

            ListNode[] nodes = reverse(curr.next, right - left + 1);
            curr.next.next = nodes[0];
            curr.next = nodes[1];
            return head;
        }
    }
    public ListNode[] reverse(ListNode curr, int k){
        ListNode prev = null;
        for(int i=0; i<k; i++){
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        
        return new ListNode[]{curr, prev};
    }
}