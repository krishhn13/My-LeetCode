import java.util.*;

class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
                int[][] dp = new int[text1.length()][text2.length()];
                for (int[] d : dp) {
                        Arrays.fill(d, -1);
                }
                return lcs(text1, text2, text1.length(), text2.length(), dp);
        }

        int lcs(String x, String y, int n, int m, int[][] dp) {
                if (n == 0 || m == 0)
                        return 0;
                if (dp[n - 1][m - 1] != -1)
                        return dp[n - 1][m - 1];
                if (x.charAt(n - 1) == y.charAt(m - 1)) {
                        dp[n - 1][m - 1] = 1 + lcs(x, y, n - 1, m - 1, dp);
                } else {
                        dp[n - 1][m - 1] = Math.max(lcs(x, y, n - 1, m, dp), lcs(x, y, n, m - 1, dp));
                }
                return dp[n - 1][m - 1];
        }
}

public class Memoized {
        public static void main(String[] args) {
                Solution sol = new Solution();
                sol.longestCommonSubsequence("abcdefgh", "abcdhreg");
        }
}
