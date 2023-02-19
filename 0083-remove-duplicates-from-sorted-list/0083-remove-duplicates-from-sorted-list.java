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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                // if(curr.next.next!=null){
                    curr.next=curr.next.next;
                    // curr.next.next = null;
                // }
            }
                else {
                    curr = curr.next;
                }
            // curr = curr.next;
        }
        return head;
    }
}