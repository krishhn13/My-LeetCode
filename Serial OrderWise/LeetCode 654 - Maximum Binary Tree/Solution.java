/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
                return func(nums, 0, nums.length - 1);
        }

        public TreeNode func(int nums[], int low, int high) {
                if (high < low) {
                        return null;
                }
                int max = Integer.MIN_VALUE, index = -1;
                for (int i = low; i <= high; i++) {
                        if (nums[i] > max) {
                                max = nums[i];
                                index = i;
                        }
                }
                TreeNode root = new TreeNode(max);
                root.left = func(nums, low, index - 1);
                root.right = func(nums, index + 1, high);
                return root;
        }
}