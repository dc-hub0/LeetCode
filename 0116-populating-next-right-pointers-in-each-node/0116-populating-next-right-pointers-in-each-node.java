class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                
                if (i < levelSize - 1) {
                    current.next = queue.peek();
                }
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
        
        return root;
    }
}
