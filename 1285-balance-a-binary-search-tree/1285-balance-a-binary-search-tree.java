import java.util.ArrayList;
import java.util.List;

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

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        return buildBalancedBST(values, 0, values.size() - 1);
    }

    private void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inorderTraversal(node.left, values);
        values.add(node.val);
        inorderTraversal(node.right, values);
    }

    private TreeNode buildBalancedBST(List<Integer> values, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBalancedBST(values, start, mid - 1);
        node.right = buildBalancedBST(values, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        TreeNode balancedRoot1 = solution.balanceBST(root1);
        printTree(balancedRoot1);

        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode balancedRoot2 = solution.balanceBST(root2);
        printTree(balancedRoot2);
    }

    private static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
