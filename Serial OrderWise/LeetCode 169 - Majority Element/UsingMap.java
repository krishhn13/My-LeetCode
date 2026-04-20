import java.util.*;

public class UsingMap{
        static class Solution {
                public int majorityElement(int[] nums) { 
                        Map<Integer, Integer> map = new HashMap<>();
                        int times = nums.length/2;
                        for(int i : nums) {
                                map.put(i, map.getOrDefault(i, 0) + 1);
                                if(map.get(i) > times) {
                                        return i;
                                }
                        }
                        return -1;
                }
        }
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.majorityElement(new int[]{2,2,2,1,3}));
        }
}