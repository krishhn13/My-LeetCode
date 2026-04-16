import java.util.*;;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    List<Integer> list = new ArrayList<>();
    int ptr = -1;
    void inorder(TreeNode root) {
        if(root == null) return ;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public BSTIterator(TreeNode root) {
        inorder(root);
    }
    
    public int next() {
        return list.get(++ptr);
    }
    
    public boolean hasNext() {
        return !(ptr == list.size()-1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */