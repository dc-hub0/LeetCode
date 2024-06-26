class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Method to deserialize a string to a linked list
    public static ListNode deserialize(String data) {
        if (data.equals("[]") || data.equals("")) return null;
        String[] values = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String val : values) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }
        return dummy.next;
    }

    // Method to serialize a linked list to a string
    public static String serialize(ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        sb.setLength(sb.length() - 1); // Remove the trailing comma
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        ListNode list1 = ListNode.deserialize("[1,2,4]");
        ListNode list2 = ListNode.deserialize("[1,3,4]");
        ListNode mergedList = solution.mergeTwoLists(list1, list2);
        System.out.println(ListNode.serialize(mergedList)); // Output: [1,1,2,3,4,4]

        // Test case 2
        ListNode list3 = ListNode.deserialize("[]");
        ListNode list4 = ListNode.deserialize("[]");
        ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        System.out.println(ListNode.serialize(mergedList2)); // Output: []

        // Test case 3
        ListNode list5 = ListNode.deserialize("[]");
        ListNode list6 = ListNode.deserialize("[0]");
        ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        System.out.println(ListNode.serialize(mergedList3)); // Output: [0]
    }
}
