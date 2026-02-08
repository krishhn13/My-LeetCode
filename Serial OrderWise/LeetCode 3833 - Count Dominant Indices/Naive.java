class Solution {
        public int dominantIndices(int[] nums) {
                int count = 0;
                for (int i = 0; i < nums.length; i++) {
                        if (nums[i] * 1.0 > avg(nums, i)) {
                                count++;
                        }
                }
                return count;
        }

        private double avg(int[] nums, int idx) {
                double len = nums.length - idx - 1;
                double sum = 0;
                for (int i = idx + 1; i < nums.length; i++) {
                        sum += nums[i];
                }
                return sum / len;
        }
}

public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = new int[] { 5, 4, 3 };
                System.out.println(sol.dominantIndices(arr));
        }
}
