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
    private int findHeight(TreeNode root) {
        if(root == null) {
            return  0;
        }
        return 1 + Math.max(findHeight(root.left), 
                            findHeight(root.right));
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null) return null;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        if(leftHeight > rightHeight) {
            return subtreeWithAllDeepest(root.left);
        } else if(leftHeight < rightHeight) {
            return subtreeWithAllDeepest(root.right);
        } else {
            return root;
        }
    }
}