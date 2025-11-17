import java.util.*;
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){
                this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
}
class Solution {
        public boolean isValidBST(TreeNode root) {
                return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        boolean isValid(TreeNode root, long mini , long maxi) {
                if (root == null) return true;
                if (root.val > mini && root.val < maxi) {
                        boolean left = isValid(root.left, mini, root.val);
                        boolean right = isValid(root.right, root.val, maxi);
                        return left && right;
                } else return false;
        }
}
public class LeetCode98 {
        public static void main(String[] args) {
                Solution sol = new Solution();

                // Example 1: valid BST [2,1,3]
                TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
                System.out.println("Tree 1 is valid BST: " + sol.isValidBST(root1)); // true

                // Example 2: invalid BST [5,1,4,null,null,3,6]
                TreeNode root2 = new TreeNode(5,
                                new TreeNode(1),
                                new TreeNode(4, new TreeNode(3), new TreeNode(6))
                );
                System.out.println("Tree 2 is valid BST: " + sol.isValidBST(root2)); // false
        }
}
