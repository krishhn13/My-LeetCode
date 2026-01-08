// LeetCode 1458 - Hard
import java.util.*;

public class Solution {
        int[][] dp;
        int n, m;

        public int maxDotProduct(int[] nums1, int[] nums2) {
                n = nums1.length;
                m = nums2.length;
                for (int[] d : dp) {
                        Arrays.fill(d, -1);
                }
                return solve(0, 0, nums1, nums2);
        }

        private int solve(int i, int j, int[] nums1, int[] nums2) {
                if (i == n || j == m) {
                        return -(int) 1e9;
                }
                if (dp[i][j] != -1) {
                        return dp[i][j];
                }
                int takeBoth = nums1[i] * nums2[j] + Math.max(0, solve(i + 1, j + 1, nums1, nums2));
                int takeOne = solve(i + 1, j, nums1, nums2);
                int takeTwo = solve(i, j + 1, nums1, nums2);
                return dp[i][j] = Math.max(takeBoth, Math.max(takeOne, takeTwo));
        }
}
