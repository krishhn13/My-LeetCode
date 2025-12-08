import java.util.*;
class Solution {
    public int[] sortByReflection(int[] nums) {
        int[] ans = new int[nums.length];
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for(int i : nums) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
            sb.reverse();
            int n = Integer.parseInt(sb.toString(),2);
            map.putIfAbsent(n,new ArrayList<>());
            map.get(n).add(i);
        }
        int idx = 0;
        for(int i : map.keySet()) {
            Collections.sort(map.get(i));
            for(int j : map.get(i)) {
                ans[idx++] = j;
            }
        }
        return ans;
    }
}
public class Answer {
        
}
