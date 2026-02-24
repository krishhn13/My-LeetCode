class Solution {
        public int sumRootToLeaf(TreeNode root) {
                if (root == null)
                        return 0;
                List<String> list = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                sb.append(root.val);
                if (root.left == null && root.right == null) {
                        return root.val;
                }
                if (root.left != null) {
                        generate(list, root.left, sb);
                }
                if (root.right != null) {
                        generate(list, root.right, sb);
                }
                int sum = 0;
                for (String st : list) {
                        sum += Integer.parseInt(st, 2);
                }
                return sum;
        }

        private void generate(List<String> list, TreeNode root, StringBuilder sb) {
                sb.append(root.val);
                if (root.left == null && root.right == null) {
                        list.add(sb.toString());
                } else {
                        if (root.left != null) {
                                generate(list, root.left, sb);
                        }
                        if (root.right != null) {
                                generate(list, root.right, sb);
                        }
                }
                sb.deleteCharAt(sb.length() - 1);
        }
}