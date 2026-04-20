import java.util.*;

public class UsingMap {
        static class Solution {
                public List<Integer> majorityElement(int[] nums) {
                        List<Integer> list = new ArrayList<>();
                        Map<Integer, Integer> map = new HashMap<>();
                        int n = nums.length;
                        for (int i = 0; i < nums.length; i++) {
                                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                                if (map.get(nums[i]) > n / 3) {
                                        list.add(nums[i]);
                                }
                        }
                        return list;
                }
        }

        public static void main(String[] args) {
                int[] nums = { 3, 2, 3 };
                Solution sol = new Solution();
                System.out.println(sol.majorityElement(nums));
        }
}