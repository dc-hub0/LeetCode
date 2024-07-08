class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        # Initialize a dummy node to handle edge cases more easily
        dummy = ListNode(0, head)
        prev = dummy
        
        while head:
            # If the current value is a duplicate, skip all nodes with this value
            if head.next and head.val == head.next.val:
                # Skip all nodes with the same value
                while head.next and head.val == head.next.val:
                    head = head.next
                # Connect prev node to the node after all duplicates
                prev.next = head.next
            else:
                # No duplicates, move prev to current node
                prev = prev.next
            # Move head to the next node
            head = head.next
        
        return dummy.next

# Helper function to create a linked list from a list
def create_linked_list(lst):
    dummy = ListNode()
    curr = dummy
    for val in lst:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

# Helper function to convert a linked list to a list
def linked_list_to_list(head):
    result = []
    while head:
        result.append(head.val)
        head = head.next
    return result

# Test the function with the given examples
solution = Solution()

head1 = create_linked_list([1,2,3,3,4,4,5])
result1 = solution.deleteDuplicates(head1)
print(linked_list_to_list(result1))  # Output: [1, 2, 5]

head2 = create_linked_list([1,1,1,2,3])
result2 = solution.deleteDuplicates(head2)
print(linked_list_to_list(result2))  # Output: [2, 3]
