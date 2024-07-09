class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode node, Integer min_val, Integer max_val) {
        // Base case: empty tree is a valid BST
        if (node == null) {
            return true;
        }
        
        // Check current node's value against min and max bounds
        if ((min_val != null && node.val <= min_val) || (max_val != null && node.val >= max_val)) {
            return false;
        }
   
        return isValidBST(node.left, min_val, node.val) && isValidBST(node.right, node.val, max_val);
    }
}
