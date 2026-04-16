class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[] start = {-1, -1}, end = {-1, -1};
        int empty = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                } else if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(start[0], start[1], end[0], end[1], grid, visited, empty);
    }
    private int dfs(int i, int j, int endR, int endC, int[][] grid, boolean[][] visited, int remaining) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || visited[i][j] || grid[i][j] == -1) {
            return 0;
        }
        if (i == endR && j == endC) {
            return remaining == -1 ? 1 : 0;
        }
        visited[i][j] = true;
        int total = 0;
        total += dfs(i, j - 1, endR, endC, grid, visited, remaining - 1);
        total += dfs(i, j + 1, endR, endC, grid, visited, remaining - 1);
        total += dfs(i - 1, j, endR, endC, grid, visited, remaining - 1);
        total += dfs(i + 1, j, endR, endC, grid, visited, remaining - 1);
        visited[i][j] = false;
        return total;
    }
}