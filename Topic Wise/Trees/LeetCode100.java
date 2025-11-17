class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
                this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
}

class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
                if (p == null && q == null)
                        return true;
                if (p == null && q != null)
                        return false;
                if (p != null && q == null)
                        return false;
                boolean left = isSameTree(p.left, q.left);
                boolean right = isSameTree(p.right, q.right);
                boolean val = p.val == q.val;
                return left && right && val;

        }
}

public class LeetCode100 {
        public static void main(String[] args) {
                Solution sol = new Solution();

                // Test 1: identical trees [1,2,3]
                TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
                TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
                System.out.println("Test1 (expected true): " + sol.isSameTree(p1, q1));

                // Test 2: different structure [1,2] vs [1,null,2]
                TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
                TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
                System.out.println("Test2 (expected false): " + sol.isSameTree(p2, q2));

                // Test 3: both null
                System.out.println("Test3 (expected true): " + sol.isSameTree(null, null));
        }

}
