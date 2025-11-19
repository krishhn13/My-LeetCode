class Solution {
        public int findFinalValue(int[] nums, int original) {
                int[] freq = new int[1001];
                for (int i : nums) {
                        freq[i]++;
                }
                while (true) {
                        if (original > 1000 || freq[original] == 0) {
                                return original;
                        }
                        original *= 2;
                }
        }
}

public class UsingArray {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.findFinalValue(new int[] { 161, 28, 640, 264, 81, 561, 320, 2, 61, 244, 183, 108,
                                773, 61, 976, 122, 988, 2, 370, 392, 488, 375, 349, 432, 713, 563 }, 34));
        }
}
