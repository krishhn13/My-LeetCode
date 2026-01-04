import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode tree = q.poll();
                sub.add(tree.val);
                if(tree.left != null) {
                    q.add(tree.left);
                }
                if(tree.right != null) {
                    q.add(tree.right);
                }
            }
            list.add(new ArrayList<>(sub));
        }
        for(int i = 0;i < list.size(); i++) {
            if(i%2 != 0) {
                Collections.reverse(list.get(i));
            }
        }
        return list;
    }
}