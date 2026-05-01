class Solution {
    int[][] dp;
    int n, m;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        dp = new int[n + 1][m + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return lcs(nums1, nums2, n, m);
    }

    private int lcs(int[] nums1, int[] nums2, int i, int j) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (nums1[i - 1] == nums2[j - 1]) {
            return dp[i][j] =  1 + lcs(nums1, nums2, i - 1, j - 1);
        } else {
            return dp[i][j] =  Math.max(lcs(nums1, nums2, i - 1, j), lcs(nums1, nums2, i, j - 1));
        }
    }
}