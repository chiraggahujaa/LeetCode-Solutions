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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;

        if(!haveKNodes(head, k)){
            return head;
        }

        ListNode curr = head, prev = null;
        for(int i=0; i<k && curr!= null; i++){
            ListNode currNext = curr.next;
            curr.next = prev;

            prev = curr;
            curr = currNext;
        }

        ListNode node = reverseKGroup(curr, k);
        head.next = node;
        return prev;
    }
    private boolean haveKNodes(ListNode head, int k){
        ListNode curr = head;
        while(curr != null && k>0){
            curr = curr.next;
            k--;
        }
        return k<=0;
    }
}