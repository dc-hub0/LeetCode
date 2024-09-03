function reverseList(head) {
    let prev = null;
    let current = head;

    while (current !== null) {
        let next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    return prev;
}

// Example usage:
function ListNode(val, next = null) {
    this.val = val;
    this.next = next;
}

const head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
const reversedHead = reverseList(head);

function printList(node) {
    const result = [];
    while (node) {
        result.push(node.val);
        node = node.next;
    }
    console.log(result);
}

printList(reversedHead); // Output: [5, 4, 3, 2, 1]
