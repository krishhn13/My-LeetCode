import java.util.*;

class Solution {
        int pI;

        void find(HashMap<Integer, Integer> map, int[] in) {
                for (int i = 0; i < in.length; i++) {
                        map.put(in[i], i);
                }
        }

        TreeNode solve(int[] in, int[] post, int iS, int iE, HashMap<Integer, Integer> index) {
                if (pI < 0 || iS > iE)
                        return null;
                int ele = post[pI--];
                TreeNode root = new TreeNode(ele);
                int pos = index.get(ele);

                root.right = solve(in, post, pos + 1, iE, index);
                root.left = solve(in, post, iS, pos - 1, index);

                return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
                pI = postorder.length - 1;
                HashMap<Integer, Integer> index = new HashMap<>();
                find(index, inorder);
                return solve(inorder, postorder, 0, inorder.length - 1, index);
        }

}