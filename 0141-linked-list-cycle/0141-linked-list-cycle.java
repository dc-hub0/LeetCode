class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    // Method to deserialize a string into a linked list for testing purposes
    static ListNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ListNode head = new ListNode(Integer.parseInt(vals[0].trim()));
        ListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(Integer.parseInt(vals[i].trim()));
            current = current.next;
        }
        return head;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example test case
        ListNode head = ListNode.deserialize("[3,2,0,-4]");
        // Create a cycle for testing purposes
        head.next.next.next.next = head.next; // Connecting -4 to 2, forming a cycle
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head)); // Should print true

        // Another test case
        head = ListNode.deserialize("[1,2]");
        head.next.next = head; // Connecting 2 to 1, forming a cycle
        System.out.println(solution.hasCycle(head)); // Should print true

        // Test case with no cycle
        head = ListNode.deserialize("[1]");
        System.out.println(solution.hasCycle(head)); // Should print false
    }
}
