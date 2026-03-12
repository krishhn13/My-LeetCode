import java.util.*;

class Solution {
        public int countCoveredBuildings(int n, int[][] buildings) {
                int[] minCol = new int[n + 1];
                int[] minRow = new int[n + 1];
                int[] maxCol = new int[n + 1];
                int[] maxRow = new int[n + 1];
                Arrays.fill(minRow, Integer.MAX_VALUE);
                Arrays.fill(minCol, Integer.MAX_VALUE);
                Arrays.fill(maxCol, -1);
                Arrays.fill(maxRow, -1);
                for (int[] b : buildings) {
                        int r = b[0], c = b[1];
                        minCol[r] = Math.min(minCol[r], c);
                        maxCol[r] = Math.max(maxCol[r], c);
                        minRow[c] = Math.min(minRow[c], r);
                        maxRow[c] = Math.max(maxRow[c], r);
                }
                int cnt = 0;
                for (int[] b : buildings) {
                        int r = b[0], c = b[1];
                        boolean left = minCol[r] < c;
                        boolean right = maxCol[r] > c;
                        boolean up = minRow[c] < r;
                        boolean down = maxRow[c] > r;
                        if (left && right && up && down)
                                cnt++;
                }
                return cnt;
        }
}