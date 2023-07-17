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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverse(l1);
        ListNode b = reverse(l2);
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int carry=0;
        while(a!=null || b!=null || carry!=0){
            int sum=carry;
            if(a!=null){
                sum+=a.val;
                a=a.next;
            }
            if(b!=null){
                sum+=b.val;
                b=b.next;
            }
            carry = sum/10;
            sum%=10;
            ans.next = new ListNode(sum);
            ans = ans.next;
        }
        return reverse(temp.next);
    }
    public ListNode reverse(ListNode node){
        ListNode curr=node,prev=null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}