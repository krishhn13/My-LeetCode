import java.util.*;

class Solution {
        int[][] dp;

        public int minDistance(String word1, String word2) {
                int n = word1.length(), m = word2.length();
                dp = new int[n + 1][m + 1];
                for (int[] d : dp) {
                        Arrays.fill(d, -1);
                }
                return n + m - 2 * solve(word1, word2, n, m);
        }

        private int solve(String s1, String s2, int n, int m) {
                if (n == 0 || m == 0) {
                        return 0;
                }
                if (dp[n][m] != -1) {
                        return dp[n][m];
                }
                if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                        return dp[n][m] = 1 + solve(s1, s2, n - 1, m - 1);
                } else {
                        return dp[n][m] = Math.max(solve(s1, s2, n - 1, m), solve(s1, s2, n, m - 1));
                }
        }
}