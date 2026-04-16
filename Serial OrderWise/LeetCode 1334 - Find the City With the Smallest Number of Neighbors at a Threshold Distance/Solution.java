import java.util.*;

class Solution {
        public int findTheCity(int n, int[][] edges, int thresh) {
                int[][] dist = new int[n][n];
                for (int i = 0; i < n; i++) {
                        Arrays.fill(dist[i], (int) 1e9);
                        dist[i][i] = 0;
                }
                for (int[] e : edges) {
                        dist[e[0]][e[1]] = e[2];
                        dist[e[1]][e[0]] = e[2];
                }
                for (int k = 0; k < n; k++) {
                        for (int i = 0; i < n; i++) {
                                for (int j = 0; j < n; j++) {
                                        if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE)
                                                continue;
                                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                                }
                        }
                }
                int mini = Integer.MAX_VALUE;
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                        int count = 0;
                        for (int j = 0; j < n; j++) {
                                if (dist[i][j] <= thresh)
                                        count++;
                        }
                        if (mini >= count) {
                                mini = count;
                                cnt = i;
                        }
                }
                return cnt;
        }
}