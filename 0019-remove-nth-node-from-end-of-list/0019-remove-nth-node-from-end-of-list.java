class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String val : vals) {
            current.next = new ListNode(Integer.parseInt(val.trim()));
            current = current.next;
        }
        return dummy.next;
    }

   
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) sb.append(",");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
   
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;
    
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        
       
        while (first != null) {
            first = first.next;
            second = second.next;
        }
   
        second.next = second.next.next;
        
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        ListNode head1 = ListNode.deserialize("[1,2,3,4,5]");
        int n1 = 2;
        ListNode result1 = solution.removeNthFromEnd(head1, n1);
        System.out.println(result1.serialize()); 

        // Example 2
        ListNode head2 = ListNode.deserialize("[1]");
        int n2 = 1;
        ListNode result2 = solution.removeNthFromEnd(head2, n2);
        System.out.println(result2.serialize()); 

        // Example 3
        ListNode head3 = ListNode.deserialize("[1,2]");
        int n3 = 1;
        ListNode result3 = solution.removeNthFromEnd(head3, n3);
        System.out.println(result3.serialize()); 
    }
}
