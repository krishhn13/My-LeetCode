import java.util.*;

class Solution {
        public int centeredSubarrays(int[] nums) {
                int ans = 0;
                for (int i = 0; i < nums.length; i++) {
                        int sum = 0;
                        Set<Integer> set = new HashSet<>();
                        for (int j = i; j < nums.length; j++) {
                                sum += nums[j];
                                set.add(nums[j]);
                                if (set.contains(sum)) {
                                        ans++;
                                }
                        }
                }
                return ans;
        }
}

public class LC3804 {

        public static void main(String[] args) {
                Solution sol = new Solution();

                int[] nums = { 1, 2, 3, 3, 2, 1 };
                int result = sol.centeredSubarrays(nums);

                System.out.println(result);
        }
}