class Solution {
        public int findFinalValue(int[] nums, int original) {
                while (true) {
                        if (search(original, nums)) {
                                original *= 2;
                        } else {
                                return original;
                        }
                }
        }

        boolean search(int i, int[] nums) {
                for (int k : nums) {
                        if (k == i)
                                return true;
                }
                return false;
        }
}

public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.findFinalValue(new int[] { 161, 28, 640, 264, 81, 561, 320, 2, 61, 244, 183, 108,
                                773, 61, 976, 122, 988, 2, 370, 392, 488, 375, 349, 432, 713, 563 }, 34));
        }
}
