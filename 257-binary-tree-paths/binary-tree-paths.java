class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        StringBuilder sb = new StringBuilder();
        generate(root, sb, res);
        return res;
    }
    void generate(TreeNode node, StringBuilder path, List<String> res) {
        if (node == null) return;
        int len = path.length(); 
        path.append(node.val);
        if (node.left == null && node.right == null) {
            res.add(path.toString());
        } else {
            path.append("->");
            generate(node.left, path, res);
            generate(node.right, path, res);
        }
        path.setLength(len);
    }
}
