class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        // Check if we reach a leaf node and the target sum matches
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }
        
        // Recursively check left and right subtrees
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    
    public static void main(String[] args) {
        // Example 1:
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);
        int targetSum1 = 22;
        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(root1, targetSum1)); // Output: true
        
        // Example 2:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        int targetSum2 = 5;
        System.out.println(solution.hasPathSum(root2, targetSum2)); // Output: false
        
        // Example 3:
        TreeNode root3 = null;
        int targetSum3 = 0;
        System.out.println(solution.hasPathSum(root3, targetSum3)); // Output: false
    }
}
