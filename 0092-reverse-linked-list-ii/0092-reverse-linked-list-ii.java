class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1); // dummy node to handle cases where left = 1
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move prev to the node just before the left position
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // prev is now at the node before the reversed section
        ListNode current = prev.next;
        ListNode next = null;
        ListNode tail = current; // this will be the tail of the reversed segment
        
        // Reverse the segment from left to right
        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        
        // Connect the tail of the reversed segment to the rest of the list
        tail.next = current;
        
        // Return the updated head
        return dummy.next;
    }
}
