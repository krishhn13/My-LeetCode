import java.util.*;
// Beats 99.11% in Time and 5.22% in memory
// O(n) Time (2ms) and O(n) Space (47.27MB)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store the indices
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if(map.containsKey(diff)) {
                        return new int[]{map.get(diff), i};
                } else {
                        map.put(nums[i],i);
                }
        }
        return new int[]{-1,-1};
    }
}
public class Optimised {
        public static void main(String[] args) {
                Solution s = new Solution();
                int[] nums = new int[]{1,2,3,4,2};
                System.out.println(s.twoSum(nums, 4));
        }
}
