/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int len =0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast  = fast.next.next;
            if(fast == slow){
                ListNode temp = slow;
                do{
                 temp = temp.next;
                    len++;
                }while(temp!=slow);
                break;
            }
        }
        if(len==0) return null;
        fast = head;
        slow = head;
        while(len>0){
            fast = fast.next;
            len--;
        }
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}