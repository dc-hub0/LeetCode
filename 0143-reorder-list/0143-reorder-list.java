class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
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

     static String serialize(ListNode head) {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (head != null) {
            sb.append(head.val);
            head = head.next;
            if (head != null) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

         ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

         ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

         ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args) {
         ListNode head1 = ListNode.deserialize("[1,2,3,4]");
        new Solution().reorderList(head1);
        System.out.println(ListNode.serialize(head1));  

         ListNode head2 = ListNode.deserialize("[1,2,3,4,5]");
        new Solution().reorderList(head2);
        System.out.println(ListNode.serialize(head2));   
    }
}
