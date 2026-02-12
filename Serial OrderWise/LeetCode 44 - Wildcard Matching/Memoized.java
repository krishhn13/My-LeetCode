import java.util.*;

class Solution {
        int[][] dp;
        public boolean isMatch(String s, String p) {
                int n = s.length();
                int m = p.length();
                dp = new int[n][m];
                for (int[] d : dp) {
                        Arrays.fill(d, -1);
                }
                return solve(s, p, n, m);
        }

        private boolean solve(String s, String p, int n, int m) {
                if (n == 0 && m == 0) {
                        return true;
                }
                if (m == 0) {
                        return false;
                }
                if (n == 0) {
                        for (int i = 0; i < m; i++) {
                                if (p.charAt(i) != '*') {
                                        return false;
                                }
                        }
                        return true;
                }
                if (dp[n - 1][m - 1] != -1) {
                        return dp[n - 1][m - 1] == 1;
                }
                boolean ans = false;
                if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
                        ans = solve(s, p, n - 1, m - 1);
                } else if (p.charAt(m - 1) == '*') {
                        if (solve(s, p, n - 1, m) || solve(s, p, n, m - 1)) {
                                ans = true;
                        }
                }
                if (ans) {
                        dp[n - 1][m - 1] = 1;
                } else {
                        dp[n - 1][m - 1] = 0;
                }
                return ans;
        }
}

public class Memoized {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isMatch("aa", "*?"));
        }
}