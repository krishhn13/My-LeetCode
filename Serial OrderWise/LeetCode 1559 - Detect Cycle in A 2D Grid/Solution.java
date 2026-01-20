class Solution {
        boolean[][] visited;
        int n, m;

        public boolean containsCycle(char[][] grid) {
                n = grid.length;
                m = grid[0].length;
                visited = new boolean[n][m];
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                                if (!visited[i][j] && dfs(grid, i, j, -1, -1, grid[i][j])) {
                                        return true;
                                }
                        }
                }
                return false;
        }

        private boolean dfs(char[][] grid, int i, int j, int parI, int parJ, char ch) {
                if (i < 0 || i >= n || j < 0 || j >= m) {
                        return false;
                }
                if (grid[i][j] != ch) {
                        return false;
                }
                if (visited[i][j]) {
                        return true;
                }
                visited[i][j] = true;
                int[][] directions = {
                                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
                };
                for (int[] arr : directions) {
                        int nR = i + arr[0];
                        int nC = j + arr[1];
                        if (nR == parI && nC == parJ)
                                continue;
                        if (dfs(grid, nR, nC, i, j, ch))
                                return true;
                }
                return false;
        }
}