class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flatten(root.left);
        flatten(root.right);
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // Flatten the tree
        root.left = null;
        root.right = left;
        
        // Find the end of the current flattened tree to append the right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        
        // Append the right subtree
        current.right = right;
    }
    
    public static void main(String[] args) {
        // Example 1:
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(6);
        
        Solution solution = new Solution();
        solution.flatten(root1);
        System.out.println("Example 1 flattened tree:");
        printTree(root1); // Output: [1,null,2,null,3,null,4,null,5,null,6]
        
        // Example 2:
        TreeNode root2 = null;
        solution.flatten(root2);
        System.out.println("\nExample 2 flattened tree:");
        printTree(root2); // Output: []
        
        // Example 3:
        TreeNode root3 = new TreeNode(0);
        solution.flatten(root3);
        System.out.println("\nExample 3 flattened tree:");
        printTree(root3); // Output: [0]
    }
    
    // Helper method to print the flattened tree in pre-order traversal
    private static void printTree(TreeNode node) {
        if (node == null) {
            System.out.print("[]");
            return;
        }
        
        System.out.print("[" + node.val + ",");
        printTree(node.left);
        System.out.print(",");
        printTree(node.right);
        System.out.print("]");
    }
}
