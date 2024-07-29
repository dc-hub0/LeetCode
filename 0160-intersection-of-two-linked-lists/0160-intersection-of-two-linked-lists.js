// Definition for singly-linked list.
function ListNode(val) {
    this.val = val;
    this.next = null;
}

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    if (headA === null || headB === null) {
        return null;
    }
    
    let pA = headA;
    let pB = headB;
    
    // Traverse both lists
    while (pA !== pB) {
        // Move to the next node or switch to the head of the other list
        pA = pA === null ? headB : pA.next;
        pB = pB === null ? headA : pB.next;
    }
    
    return pA;
};

// Example usage:

// Create intersection node
const intersectNode = new ListNode(8);
intersectNode.next = new ListNode(4);
intersectNode.next.next = new ListNode(5);

// Create first list
const listA = new ListNode(4);
listA.next = new ListNode(1);
listA.next.next = intersectNode;

// Create second list
const listB = new ListNode(5);
listB.next = new ListNode(6);
listB.next.next = new ListNode(1);
listB.next.next.next = intersectNode;

console.log(getIntersectionNode(listA, listB)); // Output: Intersected at node with value 8
