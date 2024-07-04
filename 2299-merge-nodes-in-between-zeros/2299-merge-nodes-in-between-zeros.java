import java.util.*;

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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        ListNode temp = head.next;
        int sum = 0;

        while (temp != null) {
            if (temp.val != 0) {
                sum += temp.val;
            } else {
                current.next = new ListNode(sum);
                current = current.next;
                sum = 0;
            }
            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode head1 = ListNode.deserialize("[0,3,1,0,4,5,2,0]");
        ListNode result1 = solution.mergeNodes(head1);
        System.out.println(ListNode.serialize(result1)); // Output: [4,11]

        // Example 2
        ListNode head2 = ListNode.deserialize("[0,1,0,3,0,2,2,0]");
        ListNode result2 = solution.mergeNodes(head2);
        System.out.println(ListNode.serialize(result2)); // Output: [1,3,4]
    }
}
