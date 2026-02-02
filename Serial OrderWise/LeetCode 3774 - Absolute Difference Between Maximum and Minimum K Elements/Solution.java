import java.util.*;
class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int s1 = 0, s2 = 0;
        int n = nums.length;
        for(int i = 0;i<k;i++) {
            s1+=nums[i];
            s2+=nums[n-i-1];
        }
        return Math.abs(s1-s2);
    }
}