class Solution {
        public int longestSubarray(int[] nums) {
                int maxi = Integer.MIN_VALUE;
                for (int i : nums) {
                        if (maxi < i)
                                maxi = i;
                }
                int length = 1;
                int ans = 0;
                for (int i = 0; i < nums.length - 1; i++) {
                        if (nums[i] == maxi && nums[i + 1] == maxi) {
                                length++;
                        } else {
                                if (ans < length)
                                        ans = length;
                                length = 1;
                        }
                }
                if (ans < length)
                        ans = length;
                return ans;
        }
}