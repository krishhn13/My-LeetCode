class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isIt(root.left, root.right);
    }
    private boolean isIt(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p != null && q == null) {
            return false;
        }
        if(p == null && q != null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isIt(p.left, q.right) &&  isIt(p.right, q.left);
    }
}