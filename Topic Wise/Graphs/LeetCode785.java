import java.util.*;

class Solution {
        public boolean isBipartite(int[][] graph) {
                int n = graph.length;
                int[] color = new int[n];
                Arrays.fill(color, -1);

                for (int i = 0; i < n; i++) {
                        if (color[i] == -1) {
                                if (!dfs(i, 0, color, graph))
                                        return false;
                        }
                }
                return true;
        }

        boolean dfs(int node, int c, int[] color, int[][] graph) {
                color[node] = c;
                for (int it : graph[node]) {
                        if (color[it] == -1) {
                                if (!dfs(it, 1 - c, color, graph))
                                        return false;
                        } else if (color[it] == c) {
                                return false;
                        }
                }
                return true;
        }
}

public class LeetCode785 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
                System.out.println(sol.isBipartite(graph));
        
        }
}
