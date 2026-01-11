import java.util.*;
public class Solution {
        public int centeredSubarrays(int[] nums) {
                int ans = 0;
                for(int i = 0; i < nums.length; i++) {
                        int sum = 0;
                        Set<Integer> set = new HashSet<>();
                        for(int j = i; j < nums.length; j++) {
                                sum+=nums[j];
                                set.add(nums[j]);
                                if(set.contains(sum)) {
                                        ans++;
                                }
                        }
                }
                return ans;
        }
}
