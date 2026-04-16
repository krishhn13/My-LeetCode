import java.util.*;

class Solution {
        public int[] rotateElements(int[] nums, int k) {
                List<Integer> idx = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                        if (nums[i] >= 0)
                                idx.add(i);
                }
                int n = idx.size();
                if (n == 0)
                        return nums;
                k %= n;
                int[] ans = Arrays.copyOf(nums, nums.length);
                for (int i = 0; i < n; i++) {
                        int fromIndex = idx.get(i);
                        int toIndex = idx.get((i - k + n) % n);
                        ans[toIndex] = nums[fromIndex];
                }
                return ans;
        }
}
