class Solution {
        public int minOperations(int[] nums) {
                if (nums.length == 1)
                        return 0;
                int count = 0;
                for (int i = 1; i < nums.length; i++) {
                        if (nums[i] <= nums[i - 1]) {
                                count += (nums[i - 1] - nums[i] + 1);
                                nums[i] += (nums[i - 1] - nums[i] + 1);
                        }
                }
                return count;
        }
}
public class LeetCode1827 {
         public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = {1,24,45,23,11,90};
                System.out.println(sol.minOperations(arr));
        }
}
