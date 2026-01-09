class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + 
        Math.max(height(root.left), height(root.right));
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return null ;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if(leftHeight > rightHeight) {
            return lcaDeepestLeaves(root.left);
        } else if(leftHeight < rightHeight) {
            return lcaDeepestLeaves(root.right);
        } else {
            return root;
        }
    }
}