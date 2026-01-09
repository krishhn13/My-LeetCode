class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {

        }
        TreeNode(int val) {
                this.val = val;
                this.left = null;
                this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
}
public class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
                if(root == null) {
                        return new TreeNode(val);
                }
                 if(root.val > val && root.left!=null) {
                root.left = insertIntoBST(root.left, val);
                }        
                if(root.val < val && root.right!=null) {
                root.right =  insertIntoBST(root.right, val);
                }        
                if(root.val < val && root.right == null) {
                root.right = new TreeNode(val);
                }
                if(root.val > val && root.left == null) {
                root.left = new TreeNode(val);
                }
                return root;
        }        
}
