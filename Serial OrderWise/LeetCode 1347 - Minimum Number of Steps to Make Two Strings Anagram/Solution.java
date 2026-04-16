import java.util.*;

class Solution {
        public int minSteps(String s, String t) {
                HashMap<Character, Integer> map = new HashMap<>();
                HashMap<Character, Integer> map2 = new HashMap<>();
                for (char c : s.toCharArray()) {
                        map.put(c, map.getOrDefault(c, 0) + 1);
                }
                for (char c : t.toCharArray()) {
                        map2.put(c, map2.getOrDefault(c, 0) + 1);
                }
                int steps = 0;
                for (char c = 'a'; c <= 'z'; c++) {
                        int count1 = map.getOrDefault(c, 0);
                        int count2 = map2.getOrDefault(c, 0);
                        steps += Math.abs(count1 - count2);
                }

                return steps / 2;
                // because we are comparing two strings
        }
}