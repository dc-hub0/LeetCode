class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 
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
 
    static void createCycle(ListNode head, int pos) {
        if (pos == -1) return;

        ListNode tail = head;
        ListNode cycleNode = null;
        int index = 0;
        while (tail.next != null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }
        tail.next = cycleNode;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                 ListNode pointer = head;
                while (pointer != slow) {
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;
            }
        }

        return null; 
    }

    public static void main(String[] args) {
         ListNode head1 = ListNode.deserialize("[3,2,0,-4]");
        ListNode.createCycle(head1, 1);
        Solution solution = new Solution();
        ListNode cycleNode1 = solution.detectCycle(head1);
        System.out.println(cycleNode1 != null ? cycleNode1.val : "no cycle");

         ListNode head2 = ListNode.deserialize("[1,2]");
        ListNode.createCycle(head2, 0);
        ListNode cycleNode2 = solution.detectCycle(head2);
        System.out.println(cycleNode2 != null ? cycleNode2.val : "no cycle");

         ListNode head3 = ListNode.deserialize("[1]");
        ListNode.createCycle(head3, -1);
        ListNode cycleNode3 = solution.detectCycle(head3);
        System.out.println(cycleNode3 != null ? cycleNode3.val : "no cycle");
    }
}
