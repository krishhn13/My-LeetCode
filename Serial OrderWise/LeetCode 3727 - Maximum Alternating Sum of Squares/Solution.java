import java.util.*;

class Solution {
        public long maxAlternatingSum(int[] nums) {
                for (int i = 0; i < nums.length; i++) {
                        nums[i] = Math.abs(nums[i]);
                }
                Arrays.sort(nums);
                long odds = 0, evens = 0;
                for (int i = 0; i < nums.length / 2; i++) {
                        odds += nums[i] * nums[i];
                }
                for (int i = nums.length / 2; i < nums.length; i++) {
                        evens += nums[i] * nums[i];
                }
                return evens - odds;
        }
}