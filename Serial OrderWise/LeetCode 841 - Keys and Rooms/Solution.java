// Simple dfs
import java.util.*;
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(visited,rooms,0);
        for(boolean b : visited) {
            if(!b) return false;
        }
        return true;
    }
    void dfs(boolean[] visited, List<List<Integer>> rooms, int room) {
        if(visited[room]) {
            return ;
        }
        visited[room] = true;
        for(int i : rooms.get(room)) {
            dfs(visited, rooms, i);
        }
    }
}