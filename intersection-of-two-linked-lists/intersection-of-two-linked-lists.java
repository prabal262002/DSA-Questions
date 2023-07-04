/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int coA=0,coB=0;
        while(A!=null){
            A = A.next;
            coA++;
        }
        while(B!=null){
            B = B.next;
            coB++;
        }
        A=headA;B=headB;
        int sm = Math.abs(coA-coB);
        while(sm>0){
            if(coA>coB) A = A.next;
            else B = B.next; 
            sm--;
        }
        while(A!=null){
            if(A==B) return A;
            A=A.next;
            B=B.next;
        }

        return null;












    }
}