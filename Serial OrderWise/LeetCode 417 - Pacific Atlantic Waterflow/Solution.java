import java.util.*;

class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
                int m = heights.length, n = heights[0].length;
                boolean[][] pacific = new boolean[m][n];
                boolean[][] atlantic = new boolean[m][n];
                Queue<int[]> pacQ = new LinkedList<>();
                Queue<int[]> atlQ = new LinkedList<>();
                for (int i = 0; i < m; i++) {
                        pacQ.add(new int[] { i, 0 });
                        atlQ.add(new int[] { i, n - 1 });
                        pacific[i][0] = true;
                        atlantic[i][n - 1] = true;
                }
                for (int j = 0; j < n; j++) {
                        pacQ.add(new int[] { 0, j });
                        atlQ.add(new int[] { m - 1, j });
                        pacific[0][j] = true;
                        atlantic[m - 1][j] = true;
                }
                bfs(heights, pacQ, pacific);
                bfs(heights, atlQ, atlantic);
                List<List<Integer>> res = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                                if (pacific[i][j] && atlantic[i][j]) {
                                        res.add(Arrays.asList(i, j));
                                }
                        }
                }
                return res;
        }

        void bfs(int[][] h, Queue<int[]> q, boolean[][] vis) {
                int m = h.length, n = h[0].length;
                int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int r = cur[0], c = cur[1];
                        for (int[] d : dir) {
                                int nr = r + d[0], nc = c + d[1];
                                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                                        continue;
                                if (vis[nr][nc])
                                        continue;
                                if (h[nr][nc] >= h[r][c]) {
                                        vis[nr][nc] = true;
                                        q.add(new int[] { nr, nc });
                                }
                        }
                }
        }
}
