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
    int pIndex = 0;

    int findPosition(int[] inorder, int element){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == element) return i;
        }
        return -1;
    }

    TreeNode solve(int[] inorder, int[] preorder, int iStart, int iEnd){
        if(pIndex >= preorder.length || iStart > iEnd){
            return null;
        }

        int ele = preorder[pIndex++];
        TreeNode root = new TreeNode(ele);
        int position = findPosition(inorder, ele);

        root.left = solve(inorder, preorder, iStart, position - 1);
        root.right = solve(inorder, preorder, position + 1, iEnd);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(inorder, preorder, 0, inorder.length - 1);
    }
}

