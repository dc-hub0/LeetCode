class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def nodesBetweenCriticalPoints(self, head: ListNode):
        if not head or not head.next or not head.next.next:
            return [-1, -1]
        
        critical_points = []
        prev, curr = head, head.next
        index = 1
        
        while curr and curr.next:
            if (curr.val > prev.val and curr.val > curr.next.val) or (curr.val < prev.val and curr.val < curr.next.val):
                critical_points.append(index)
            prev = curr
            curr = curr.next
            index += 1
        
        if len(critical_points) < 2:
            return [-1, -1]
        
        min_distance = float('inf')
        max_distance = critical_points[-1] - critical_points[0]
        
        for i in range(1, len(critical_points)):
            min_distance = min(min_distance, critical_points[i] - critical_points[i - 1])
        
        return [min_distance, max_distance]

# Helper function to create a linked list from a list of values
def create_linked_list(vals):
    if not vals:
        return None
    head = ListNode(vals[0])
    current = head
    for val in vals[1:]:
        current.next = ListNode(val)
        current = current.next
    return head

# Test cases
sol = Solution()

# Test case 1
head1 = create_linked_list([3, 1])
print(sol.nodesBetweenCriticalPoints(head1))  # Output: [-1, -1]

# Test case 2
head2 = create_linked_list([5, 3, 1, 2, 5, 1, 2])
print(sol.nodesBetweenCriticalPoints(head2))  # Output: [1, 3]

# Test case 3
head3 = create_linked_list([1, 3, 2, 2, 3, 2, 2, 2, 7])
print(sol.nodesBetweenCriticalPoints(head3))  # Output: [3, 3]
