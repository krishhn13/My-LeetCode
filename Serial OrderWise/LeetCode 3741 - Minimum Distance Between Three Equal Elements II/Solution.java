import java.util.*;
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int idx = 0;
        for (int i : nums) {
            map.putIfAbsent(i, new ArrayList<>());
            map.get(i).add(idx);
            idx++;
        }
        int mini = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i + 2 < list.size(); i++) {
                    mini = Math.min(mini, 2*(list.get(i + 2) - list.get(i)));
                }
            }
        }
        return mini == Integer.MAX_VALUE ? -1 : mini;
    }
}