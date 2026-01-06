import java.util.*;
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
class Solution {
    public int maxLevelSum(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode tree = q.poll();
                l.add(tree.val);
                if(tree.left != null) {
                    q.add(tree.left);
                } 
                if(tree.right != null) {
                    q.add(tree.right);
                }
            }
            list.add(new ArrayList<>(l));
        }
        int maxi = -(int)1e9;
        int level = 1;
        int lt = 1;
        for(List<Integer> l : list) {
            int sum = 0;
            for(int i =  0; i < l.size(); i++) {
                sum+=l.get(i);
            }
            if(maxi < sum) {
                maxi = sum; 
                level = lt;
            }
            lt++;
        }
        return level;
    }
}