public class Solution {
    int res = -(int)1e9;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return res - 1;
    }
    private int solve(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = solve(root.left);
        int r = solve(root.right);
        int temp = Math.max(l,r) + 1;
        int ans = Math.max(temp, 1 + l + r);
        res = Math.max(ans, res);
        return temp;
    }
}