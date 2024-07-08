class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Helper method to create a linked list from an array
    public static ListNode fromArray(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to deserialize a list from a string (e.g., "[1,1,2,3,3]")
    public static ListNode deserialize(String data) {
        data = data.replaceAll("\\[|\\]|\\s", "");
        if (data.isEmpty()) return null;
        String[] values = data.split(",");
        int[] arr = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        return fromArray(arr);
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String input1 = "[1,1,2]";
        ListNode list1 = ListNode.deserialize(input1);
        list1 = solution.deleteDuplicates(list1);
        ListNode.printList(list1);  // Output: 1 2

        // Example 2
        String input2 = "[1,1,2,3,3]";
        ListNode list2 = ListNode.deserialize(input2);
        list2 = solution.deleteDuplicates(list2);
        ListNode.printList(list2);  // Output: 1 2 3
    }
}
