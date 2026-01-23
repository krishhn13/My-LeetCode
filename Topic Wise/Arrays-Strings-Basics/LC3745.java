class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int secMaxi = Integer.MIN_VALUE;
        int check = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxi) {
                maxi = nums[i];
                check = i;
            }
            if (nums[i] < mini) {
                mini = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != check && nums[i] > secMaxi) {
                secMaxi = nums[i];
            }
        }
        return maxi + secMaxi - mini;
    }
}
public class LC3745 {

        public static void main(String[] args) {
                // Example run; change the array as needed
                int[] nums = {3, 1, 5, 2, 4};

                Solution sol = new Solution();
                int ans = sol.maximizeExpressionOfThree(nums);

                System.out.println(ans);
        }
}
