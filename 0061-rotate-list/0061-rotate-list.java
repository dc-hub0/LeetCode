// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Helper method to deserialize a string to a ListNode
    public static ListNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String node : nodes) {
            current.next = new ListNode(Integer.parseInt(node.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to serialize a ListNode to a string
    public static String serialize(ListNode node) {
        if (node == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Find the length of the list and make it circular
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }
        oldTail.next = head;  // Make it circular

        // Find the new tail and the new head
        k = k % length;
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;  // Break the circular list

        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode head1 = ListNode.deserialize("[1,2,3,4,5]");
        ListNode result1 = solution.rotateRight(head1, 2);
        System.out.println(ListNode.serialize(result1)); // Output: [4,5,1,2,3]

        // Example 2
        ListNode head2 = ListNode.deserialize("[0,1,2]");
        ListNode result2 = solution.rotateRight(head2, 4);
        System.out.println(ListNode.serialize(result2)); // Output: [2,0,1]
    }
}
