import java.util.*;
class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
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
        public List<Integer> inorderTraversal(TreeNode root) {
                List<Integer> list = new ArrayList<>();
                inorder(root,list);
                return list;
        }
        private void inorder(TreeNode root,List<Integer> list) {
                if(root == null) return;
                inorder(root.left, list);
                list.add(root.val);
                inorder(root.right, list);
        } 
}

public class LeetCode94 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                TreeNode root = new TreeNode();
                System.out.println(sol.inorderTraversal(root));
        }
}