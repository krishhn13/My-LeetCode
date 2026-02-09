class Solution {
        public int search(int[] nums, int target) {
                for (int i = 0; i < nums.length; i++) {
                        if (nums[i] == target)
                                return i;
                }
                return -1;
        }
}

public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        }
}
