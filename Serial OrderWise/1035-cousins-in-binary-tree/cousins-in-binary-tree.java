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
class Pair{
    TreeNode node;
    int parent;
    Pair(TreeNode node , int parent) {
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    void levelOrder(TreeNode root,List<List<Pair>> res) {
        if(root == null) return ;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,root.val));
        while(!q.isEmpty()) {
            int size = q.size();
            List<Pair> list =new ArrayList<>();
            for(int i = 0;i<size;i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                list.add(new Pair(p.node,p.parent));
                if(node.left!=null) q.add(new Pair(node.left,node.val));
                if(node.right!=null) q.add(new Pair(node.right,node.val));
            }
            res.add(list);
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        List<List<Pair>> res = new ArrayList<>();
        levelOrder(root,res);
        for(List<Pair> l : res) {
            Pair px = null , py = null;
            for(Pair p : l) {
                if(p.node.val == x) px = p;
                if(p.node.val == y) py = p;
            }
            if(px!=null && py!=null) {
                return px.parent != py.parent; 
            }
            if((px != null && py == null) || (px == null && py != null)) {
                return false;
            }
        }
        return false;
    }
}