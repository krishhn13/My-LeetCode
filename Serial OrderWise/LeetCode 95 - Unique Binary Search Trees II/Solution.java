import java.util.*;
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        generate(n, 1, list);
        return list;
    }
    private void generate(int n, int curr, List<TreeNode> list) {
        if(curr > n) {
            list.add(null);
            return ;
        } 
        if(curr == n) {
            list.add(new TreeNode(n));
            return ;
        }
        for(int i = curr; i<= n; i++) {
            List<TreeNode> left = new ArrayList<>();
            generate(i-1, curr, left);
            List<TreeNode> right = new ArrayList<>();
            generate(n, i+1, right);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                } 
            }
        }
        return ;
    }
}