class Solution {
        public boolean canPartition(int[] nums) {
                long sum = 0;
                for (int i : nums)
                        sum += i;
                if (sum % 2 != 0)
                        return false;
                int n = nums.length;
                int m = (int) (sum / 2);
                boolean[][] dp = new boolean[n + 1][m + 1];
                for (int i = 0; i <= n; i++)
                        dp[i][0] = true;
                for (int i = 1; i <= n; i += 1) {
                        for (int j = 1; j <= m; j += 1) {
                                if (nums[i - 1] <= j) {
                                        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                                } else {
                                        dp[i][j] = dp[i - 1][j];
                                }
                        }
                }
                return dp[n][m];
        }
}