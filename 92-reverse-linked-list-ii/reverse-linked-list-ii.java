class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        int i = 1;
        ListNode curr = head, prev = null;

        // Move curr and prev to the starting position
        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode start = prev, end = curr;
        ListNode next = null;

        // Reverse the sublist
        while (i <= right) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // Connect the reversed sublist back to the original list
        if (start != null) {
            start.next = prev;
        } else {
            head = prev; // Update head if reversing from the beginning
        }

        end.next = curr;

        return head;
    }
}
