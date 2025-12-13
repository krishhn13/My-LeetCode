import java.util.*;

class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
                Map<Integer, Integer> map = new LinkedHashMap<>();
                for (int i = 0; i < heights.length; i++) {
                        map.put(i, heights[i]);
                }
                List<Integer> list = new ArrayList<>(map.values());
                Collections.sort(list, Collections.reverseOrder());
                // String[] ans = new String[names.length];
                int k = 0;
                for (int i : map.keySet()) {
                        map.put(i, list.get(k));
                        k++;
                }
                Map<Integer, String> map1 = new HashMap<>();
                for (int i = 0; i < heights.length; i++) {
                        map1.put(heights[i], names[i]);
                }
                k = 0;
                String[] ans = new String[names.length];
                for (int i : map.values()) {
                        ans[k++] = map1.get(i);
                }
                return ans;
        }
}

public class FirstThought {
        public static void main(String[] args) {
                Solution sol = new Solution();
                String[] names = { "Mary", "John", "Emma" };
                int[] heights = { 180, 165, 170 };
                System.out.println(sol.sortPeople(names, heights));
                ;
        }
}
