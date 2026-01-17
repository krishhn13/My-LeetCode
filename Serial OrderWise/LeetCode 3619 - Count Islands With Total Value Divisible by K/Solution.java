class Solution {
    boolean[][] visited;
    int n, m;
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0 && !visited[i][j]) {
                    if(dfs(grid, i, j) % k == 0) {
                        count++;
                    } 
                }
            }
        }
        return count;
    }
    private long dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        long revolved = dfs(grid, i+1, j) + dfs(grid, i, j+1) + dfs(grid, i-1, j) + dfs(grid, i, j-1);
        return grid[i][j] + revolved;
    }
}