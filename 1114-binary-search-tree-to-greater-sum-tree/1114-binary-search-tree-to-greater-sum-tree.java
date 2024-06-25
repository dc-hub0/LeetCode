class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
         
            bstToGst(root.right);
          
            sum += root.val;
            root.val = sum;
           
            bstToGst(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(0);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        root1.left.right.right = new TreeNode(3);
        root1.right.right.right = new TreeNode(8);

        TreeNode result1 = solution.bstToGst(root1);
        printTree(result1); 

        // Example 2
        TreeNode root2 = new TreeNode(0);
        root2.right = new TreeNode(1);

        TreeNode result2 = solution.bstToGst(root2);
        printTree(result2); 
    }

    private static void printTree(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }
}
