import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    void addEdge(int src, int des) {
        map.putIfAbsent(src, new ArrayList<>());
        map.putIfAbsent(des, new ArrayList<>());
        map.get(src).add(des);
        map.get(des).add(src);
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        for(int[] e : edges) {
            addEdge(e[0], e[1]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, visited, destination);
    }
    boolean dfs(int src, boolean[] visited, int des) {
        if(src == des) return true;
        if(visited[src]) return false;
        visited[src] = true;
        for(int i : map.getOrDefault(src, new ArrayList<>())) {
            if (!visited[i] && dfs(i, visited, des)) {
                return true;
            }
        }
        return false;
    }
}