import java.util.*;

class Solution {
        public int sumOfUnique(int[] nums) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i : nums) {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                }
                int sum = 0;
                for (int i : map.keySet()) {
                        if (map.get(i) == 1)
                                sum += i;
                }
                return sum;
        }
}

public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.sumOfUnique(new int[] { 1, 1, 1, 1, 1 }));
        }
}
