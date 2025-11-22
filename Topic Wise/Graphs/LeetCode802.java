import java.util.*;

class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {
                int V = graph.length;
                int[] visited = new int[V];
                int[] pathVis = new int[V];
                int[] check = new int[V];

                for (int i = 0; i < V; i++) {
                        if (visited[i] == 0) {
                                dfs(i, graph, visited, pathVis, check);
                        }
                }

                List<Integer> safeList = new ArrayList<>();
                for (int i = 0; i < V; i++) {
                        if (check[i] == 1)
                                safeList.add(i);
                }

                return safeList;
        }

        boolean dfs(int node, int[][] graph, int[] visited, int[] pathVis, int[] check) {
                visited[node] = 1;
                pathVis[node] = 1;
                check[node] = 0;

                for (int adj : graph[node]) {
                        if (visited[adj] == 0) {
                                if (dfs(adj, graph, visited, pathVis, check))
                                        return true;
                        } else if (pathVis[adj] == 1) {
                                return true;
                        }
                }

                check[node] = 1;
                pathVis[node] = 0;
                return false;
        }
}

public class LeetCode802 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[][] graph = {
                                { 1, 2 },
                                { 2, 3 },
                                { 5 },
                                { 0 },
                                { 5 },
                                {},
                                {}
                };

                List<Integer> safeNodes = sol.eventualSafeNodes(graph);
                System.out.println(safeNodes);
        }
}
