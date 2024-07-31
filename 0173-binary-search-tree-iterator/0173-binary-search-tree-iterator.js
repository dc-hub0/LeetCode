class TreeNode {
    constructor(val = 0, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    constructor(root) {
        this.stack = [];
        this._leftmostInorder(root);
    }

    _leftmostInorder(node) {
        while (node !== null) {
            this.stack.push(node);
            node = node.left;
        }
    }

    next() {
    
        let topmostNode = this.stack.pop();

      
        if (topmostNode.right !== null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    hasNext() {
        return this.stack.length > 0;
    }
}

const root = new TreeNode(7);
root.left = new TreeNode(3);
root.right = new TreeNode(15);
root.right.left = new TreeNode(9);
root.right.right = new TreeNode(20);

const bSTIterator = new BSTIterator(root);
console.log(bSTIterator.next());   
console.log(bSTIterator.next());   
console.log(bSTIterator.hasNext()); 
console.log(bSTIterator.next());  
console.log(bSTIterator.hasNext()); 
console.log(bSTIterator.next());   
console.log(bSTIterator.hasNext()); 
console.log(bSTIterator.next());   
console.log(bSTIterator.hasNext()); 
