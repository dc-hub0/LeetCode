import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        
        List<TreeNode> forest = new ArrayList<>();
        dfs(root, true, toDeleteSet, forest);
        return forest;
    }
    
    private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        
        boolean toDelete = toDeleteSet.contains(node.val);
        if (isRoot && !toDelete) {
            forest.add(node);
        }
        
        node.left = dfs(node.left, toDelete, toDeleteSet, forest);
        node.right = dfs(node.right, toDelete, toDeleteSet, forest);
        
        return toDelete ? null : node;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        int[] to_delete1 = {3, 5};
        List<TreeNode> result1 = solution.delNodes(root1, to_delete1);
        System.out.println("Forest 1:");
        for (TreeNode tree : result1) {
            printTree(tree);
            System.out.println();
        }
        
        // Test case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(4);
        root2.left.right = new TreeNode(3);
        int[] to_delete2 = {3};
        List<TreeNode> result2 = solution.delNodes(root2, to_delete2);
        System.out.println("Forest 2:");
        for (TreeNode tree : result2) {
            printTree(tree);
            System.out.println();
        }
    }
    
    private static void printTree(TreeNode node) {
        if (node == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(node.val + " ");
                printTree(node.left);
        printTree(node.right);
    }
}

