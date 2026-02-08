class Solution {
        public int dominantIndices(int[] nums) {
                int count = 0;
                double avg = 0;
                for (int i : nums) {
                        avg += i;
                }
                int len = nums.length - 1;
                for (int i = 0; i < nums.length; i++) {
                        if (len > 0 && nums[i] * 1.0 > (avg - nums[i]) / len) {
                                count++;
                        }
                        len--;
                        avg -= nums[i];
                }
                return count;
        }
}

public class Optimal {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = new int[] { 5, 4, 3 };
                System.out.println(sol.dominantIndices(arr));
        }
}
