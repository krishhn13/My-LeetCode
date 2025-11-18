import java.util.Arrays;

class Solution {
        public int maximizeExpressionOfThree(int[] nums) {
                Arrays.sort(nums);
                int n = nums.length;
                return nums[n-1] + nums[n-2] - nums[0];
        }
}

public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                sol.maximizeExpressionOfThree(new int[] { 4, 12, 3, 1, 0 });
        }
}
