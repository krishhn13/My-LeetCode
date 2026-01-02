import java.util.*;
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    void addEdge(int src, int des) {
        map.putIfAbsent(src, new ArrayList<>());
        map.putIfAbsent(des, new ArrayList<>());
        map.get(src).add(des);
        map.get(des).add(src);
    }
    public int findCenter(int[][] edges) {
        int n = edges.length;
        for(int[] e: edges) {
            addEdge(e[0], e[1]);
        }
        for(int i : map.keySet()) {
            if(map.get(i).size() == n) {
                return i;
            } 
        }
        return -1;
    }
}