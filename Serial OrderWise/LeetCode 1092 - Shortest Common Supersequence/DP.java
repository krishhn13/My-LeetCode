// LC 1092 - Marked As Hard
// Time : O(m*n)
// Space : O(m*n)
class Solution {
        public String shortestCommonSupersequence(String s1, String s2) {
                int m = s1.length(), n = s2.length();
                // Tabulation (Bottom-Up) DP Array in the making
                int[][] dp = new int[m + 1][n + 1];
                for (int i = 1; i <= m; i++) {
                        for (int j = 1; j <= n; j++) {
                                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                                        dp[i][j] = 1 + dp[i - 1][j - 1];
                                } else {
                                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                                }
                        }
                }
                return find(s1, s2, m, n, dp);
        }

        private String find(String s1, String s2, int m, int n, int[][] dp) {
                StringBuilder sb = new StringBuilder();
                int i = m, j = n;
                while (i > 0 && j > 0) {
                        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                                sb.append(s1.charAt(i - 1));
                                i--;
                                j--;
                        } else {
                                if (dp[i - 1][j] > dp[i][j - 1]) {
                                        sb.append(s1.charAt(i - 1));
                                        i--;
                                } else {
                                        sb.append(s2.charAt(j - 1));
                                        j--;
                                }
                        }
                }
                while (i > 0) {
                        sb.append(s1.charAt(i - 1));
                        i--;
                }
                while (j > 0) {
                        sb.append(s2.charAt(j - 1));
                        j--;
                }
                return sb.reverse().toString();
        }
}

public class DP {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.shortestCommonSupersequence("abac", "cab"));
        }
}