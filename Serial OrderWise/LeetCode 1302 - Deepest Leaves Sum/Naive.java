import java.util.*;

class Solution {
        private void findLevelOrder(TreeNode root, List<List<Integer>> list) {
                if (root == null)
                        return;
                Queue<TreeNode> q = new ArrayDeque<>();
                q.add(root);
                while (!q.isEmpty()) {
                        int size = q.size();
                        List<Integer> temp = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                                TreeNode t = q.poll();
                                temp.add(t.val);
                                if (t.left != null) {
                                        q.add(t.left);
                                }
                                if (t.right != null) {
                                        q.add(t.right);
                                }
                        }
                        list.add(new ArrayList<>(temp));
                }
        }

        public int deepestLeavesSum(TreeNode root) {
                if (root == null)
                        return 0;
                List<List<Integer>> list = new ArrayList<>();
                findLevelOrder(root, list);
                List<Integer> l = list.get(list.size() - 1);
                int sum = 0;
                for (int i : l) {
                        sum += i;
                }
                return sum;
        }
}

public class Naive {
        public static void main(String[] args) {
                // Tree:
                // 1
                // / \
                // 2 3
                // / \ \
                // 4 5 6
                // /
                // 7

                TreeNode root = new TreeNode(1);
                root.left = new TreeNode(2);
                root.right = new TreeNode(3);

                root.left.left = new TreeNode(4);
                root.left.right = new TreeNode(5);
                root.right.right = new TreeNode(6);

                root.left.left.left = new TreeNode(7);

                Solution sol = new Solution();
                int ans = sol.deepestLeavesSum(root);

                System.out.println(ans); // expected output: 7
        }
}
