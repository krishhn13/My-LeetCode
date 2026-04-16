import java.util.*;

class Solution {
        public int longestBalanced(int[] nums) {
                int maxi = 0;
                for (int i = 0; i < nums.length; i++) {
                        Set<Integer> even = new HashSet<>();
                        Set<Integer> odd = new HashSet<>();
                        for (int j = i; j < nums.length; j++) {
                                int val = nums[j];
                                if (val % 2 != 0)
                                        odd.add(val);
                                else
                                        even.add(val);
                                if (even.size() == odd.size())
                                        maxi = Math.max(maxi, j - i + 1);
                        }
                }
                return maxi;
        }
}