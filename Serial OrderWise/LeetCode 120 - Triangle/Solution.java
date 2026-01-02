import java.util.*;
class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return generate(triangle, 0, 0, n);
    }

    int generate(List<List<Integer>> triangle, int row, int col, int n) {
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != Integer.MIN_VALUE) {
            return dp[row][col];
        }
        int currentVal = triangle.get(row).get(col);
        int leftPath = generate(triangle, row + 1, col, n);
        int rightPath = generate(triangle, row + 1, col + 1, n);
        dp[row][col] = currentVal + Math.min(leftPath, rightPath);
        return dp[row][col];
    }
}