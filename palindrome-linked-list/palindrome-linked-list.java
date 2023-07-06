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
    public boolean isPalindrome(ListNode head) {
        // First we we'll find the middle of th linkedlist

        ListNode slo=head,fst=head,prev = head;
        if(fst.next==null) return true;
        while(fst.next!=null && fst.next.next!=null){
            fst=fst.next.next;
            slo=slo.next;
        }
        prev = null;
        ListNode curr = slo.next;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slo.next = prev;
        while(prev!=null){
            if(prev.val!=head.val) return false;
            prev= prev.next;
            head = head.next;
        }

        return true;
    }
}