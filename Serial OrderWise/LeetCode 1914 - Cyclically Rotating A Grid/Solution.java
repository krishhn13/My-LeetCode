import java.util.*;

class Solution {
        public int[][] rotateGrid(int[][] grid, int k) {
                int n = grid.length, m = grid[0].length;
                int top = 0, bottom = n - 1;
                int left = 0, right = m - 1;
                while (top < bottom && left < right) {
                        List<Integer> list = new ArrayList<>();
                        for (int i = left; i <= right; i++) {
                                list.add(grid[top][i]);
                        }
                        for (int i = top + 1; i < bottom; i++) {
                                list.add(grid[i][right]);
                        }
                        for (int i = right; i >= left; i--) {
                                list.add(grid[bottom][i]);
                        }
                        for (int i = bottom - 1; i > top; i--) {
                                list.add(grid[i][left]);
                        }
                        int len = list.size();
                        int k2 = k % len;
                        List<Integer> temp = new ArrayList<>();
                        for (int i = 0; i < len; i++) {
                                temp.add(list.get((i + k2) % len));
                        }
                        int idx = 0;
                        for (int i = left; i <= right; i++) {
                                grid[top][i] = temp.get(idx++);
                        }
                        for (int i = top + 1; i < bottom; i++) {
                                grid[i][right] = temp.get(idx++);
                        }
                        for (int i = right; i >= left; i--) {
                                grid[bottom][i] = temp.get(idx++);
                        }
                        for (int i = bottom - 1; i > top; i--) {
                                grid[i][left] = temp.get(idx++);
                        }
                        top++;
                        left++;
                        bottom--;
                        right--;
                }
                return grid;
        }
}