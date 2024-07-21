import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

    // Method to deserialize a string into a binary tree for testing purposes
    static TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        if (vals.length == 0) return null;

        TreeNode root = new TreeNode(Integer.parseInt(vals[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < vals.length && !vals[i].trim().equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i].trim()));
                queue.add(node.left);
            }
            i++;
            if (i < vals.length && !vals[i].trim().equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i].trim()));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);       // Visit the root
        preorder(node.left, result);  // Traverse the left subtree
        preorder(node.right, result); // Traverse the right subtree
    }

    public static void main(String[] args) {
        // Example test case 1
        TreeNode root1 = TreeNode.deserialize("[1,null,2,3]");
        System.out.println(new Solution().preorderTraversal(root1));  // Output: [1,2,3]

        // Example test case 2
        TreeNode root2 = TreeNode.deserialize("[]");
        System.out.println(new Solution().preorderTraversal(root2));  // Output: []

        // Example test case 3
        TreeNode root3 = TreeNode.deserialize("[1]");
        System.out.println(new Solution().preorderTraversal(root3));  // Output: [1]
    }
}
