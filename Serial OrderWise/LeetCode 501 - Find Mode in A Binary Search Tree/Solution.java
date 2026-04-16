import java.util.*;

class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {
        }

        TreeNode(int val) {
                this.val = val;
                this.left = this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
        }
}

public class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        void inorder(TreeNode root) {
                if (root == null) return;
                inorder(root.left);
                map.put(root.val, map.getOrDefault(root.val, 0) + 1);
                inorder(root.right);
        }

        public int[] findMode(TreeNode root) {
                inorder(root);
                int maxi = Integer.MIN_VALUE;
                int maxVal = 0;
                for (int i : map.keySet()) {
                        if (maxi < map.get(i)) {
                                maxi = map.get(i);
                                maxVal = i;
                        }
                }
                List<Integer> list = new ArrayList<>();
                list.add(maxVal);
                for (int i : map.keySet()) {
                        if (maxVal != i && maxi == map.get(i)) {
                                list.add(i);
                        }
                }
                int[] arr = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                        arr[i] = list.get(i);
                }
                return arr;
        }
}
