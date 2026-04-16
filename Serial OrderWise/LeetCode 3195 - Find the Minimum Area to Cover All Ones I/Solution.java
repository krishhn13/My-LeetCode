class Solution {
        public int minimumArea(int[][] grid) {
                int mini = grid.length, maxi = -1;
                int min = grid[0].length, max = -1;
                for (int i = 0; i < grid.length; i++) {
                        for (int j = 0; j < grid[i].length; j++) {
                                if (grid[i][j] == 1) {
                                        mini = Math.min(mini, i);
                                        maxi = Math.max(maxi, i);
                                        min = Math.min(min, j);
                                        max = Math.max(max, j);
                                }
                        }
                }
                int len = maxi - mini + 1;
                int wid = max - min + 1;
                return len * wid;
        }
}