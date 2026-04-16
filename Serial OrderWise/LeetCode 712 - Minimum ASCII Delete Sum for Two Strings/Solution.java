
// this question is a variation of LCS
import java.util.*;

public class Solution {
        int[][] dp;

        public int minimumDeleteSum(String s1, String s2) {
                int n = s1.length(), m = s2.length();
                dp = new int[n + 1][m + 1];
                for (int[] d : dp) {
                        Arrays.fill(d, -1);
                }
                int total = 0;
                for (char c : s1.toCharArray()) {
                        total += c;
                }
                for (char c : s2.toCharArray()) {
                        total += c;
                }
                return total - 2 * solve(s1, s2, n, m);
        }

        private int solve(String s1, String s2, int n, int m) {
                if (n == 0 || m == 0) {
                        return 0;
                }
                if (dp[n][m] != -1) {
                        return dp[n][m];
                }
                if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                        return dp[n][m] = (int) s1.charAt(n - 1) + solve(s1, s2, n - 1, m - 1);
                } else {
                        return dp[n][m] = Math.max(solve(s1, s2, n - 1, m), 
                                                   solve(s1, s2, n, m - 1));
                }
        }
}
