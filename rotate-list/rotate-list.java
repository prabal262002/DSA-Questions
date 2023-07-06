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
    public ListNode rotateRight(ListNode head, int k) {
    ListNode curr = head;
    int co=1;
    if(head==null) return head;
    while(curr!=null && curr.next!=null){
        curr = curr.next;
        co++;
    }
    curr.next = head;
    k = k%co;
    int l = co-k;
    curr = head;
    while(l>1){
        curr = curr.next;
        l--;
    }
    ListNode flag = curr.next;
    curr.next = null;
    return flag;





    }
}