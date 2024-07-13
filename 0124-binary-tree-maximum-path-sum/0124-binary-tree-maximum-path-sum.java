class Solution {

    private int maxSum;

    public int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;
      
        maxGain(root);
     
        return maxSum;
    }


    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

     
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);


        int currentPathSum = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }
}

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
