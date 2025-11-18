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

public class Optimised {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.maximizeExpressionOfThree(new int[] { 4, 12, 3, 1, 0 });
    }
}
