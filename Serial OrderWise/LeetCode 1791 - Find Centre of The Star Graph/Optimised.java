import java.util.*;
class Solution {
        public int findCenter(int[][] edges) {
                Set<Integer> set = new HashSet<>();
                for(int[] edge : edges) {
                        if(!set.add(edge[0])) {
                                return edge[0];
                        }
                        if(!set.add(edge[1])) {
                                return edge[1];
                        }
                }
                return -1;
        }
}
public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[][] edges = {{1,2},{2,3},{4,2}};
                System.out.println(sol.findCenter(edges));
        }
}
