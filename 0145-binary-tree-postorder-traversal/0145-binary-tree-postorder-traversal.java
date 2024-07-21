import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);   
        postorder(node.right, result);  
        result.add(node.val);       
    }

    public static void main(String[] args) {
      
        TreeNode root1 = TreeNode.deserialize("[1,null,2,3]");
        System.out.println(new Solution().postorderTraversal(root1));  
         TreeNode root2 = TreeNode.deserialize("[]");
        System.out.println(new Solution().postorderTraversal(root2));   

         TreeNode root3 = TreeNode.deserialize("[1]");
        System.out.println(new Solution().postorderTraversal(root3));  
    }
}
