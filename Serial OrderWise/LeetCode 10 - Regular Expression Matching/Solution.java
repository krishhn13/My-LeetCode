import java.util.*;

class Solution {
        int[][] dp;

        public boolean isMatch(String s, String p) {
                dp = new int[s.length() + 1][p.length() + 1];
                for (int[] d : dp) {
                        Arrays.fill(d, -1);
                }
                return solve(s, p, s.length(), p.length());
        }

        private boolean solve(String s, String p, int n, int m) {
                if (n == 0 && m == 0) {
                        return true;
                }
                if (m == 0)
                        return n == 0;
                if (n == 0) {
                        if (m % 2 != 0)
                                return false;
                        for (int i = 1; i < m; i += 2) {
                                if (p.charAt(i) != '*') {
                                        return false;
                                }
                        }
                        return true;
                }
                if (dp[n][m] != -1)
                        return dp[n][m] == 1;
                boolean ans = false;
                if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '.') {
                        ans = solve(s, p, n - 1, m - 1);
                } else if (p.charAt(m - 1) == '*') {
                        if (solve(s, p, n, m - 2)) {
                                ans = true;
                        } else if (p.charAt(m - 2) == s.charAt(n - 1) || p.charAt(m - 2) == '.') {
                                if (solve(s, p, n - 1, m))
                                        ans = true;
                        }
                }
                if (ans) {
                        dp[n][m] = 1;
                } else {
                        dp[n][m] = 0;
                }
                return ans;
        }
}