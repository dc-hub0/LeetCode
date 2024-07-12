import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }
    
    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        
        currentPath.add(node.val);
        
        // Check if we reach a leaf node and the remaining sum matches
        if (node.left == null && node.right == null && remainingSum - node.val == 0) {
            result.add(new ArrayList<>(currentPath));
        }
        
        // Recursively search left and right subtrees
        dfs(node.left, remainingSum - node.val, currentPath, result);
        dfs(node.right, remainingSum - node.val, currentPath, result);
        
        // Backtrack: remove the current node from the current path
        currentPath.remove(currentPath.size() - 1);
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
        root1.right.right.left = new TreeNode(5);
        root1.right.right.right = new TreeNode(1);
        int targetSum1 = 22;
        Solution solution = new Solution();
        List<List<Integer>> result1 = solution.pathSum(root1, targetSum1);
        System.out.println("Example 1:");
        System.out.println(result1); // Output: [[5, 4, 11, 2], [5, 8, 4, 5]]
        
        // Example 2:
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        int targetSum2 = 5;
        List<List<Integer>> result2 = solution.pathSum(root2, targetSum2);
        System.out.println("\nExample 2:");
        System.out.println(result2); // Output: []
        
        // Example 3:
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        int targetSum3 = 0;
        List<List<Integer>> result3 = solution.pathSum(root3, targetSum3);
        System.out.println("\nExample 3:");
        System.out.println(result3); // Output: []
    }
}
