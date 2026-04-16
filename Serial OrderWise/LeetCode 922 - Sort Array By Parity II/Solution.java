import java.util.*;

class Solution {
        public int[] sortArrayByParityII(int[] nums) {
                ArrayList<Integer> arr = new ArrayList<>();
                ArrayList<Integer> arr2 = new ArrayList<>();
                for (int i : nums) {
                        if (i % 2 == 0)
                                arr.add(i);
                        else
                                arr2.add(i);
                }
                int[] ans = new int[nums.length];
                int i1 = 0, i2 = 0;
                for (int i = 0; i < ans.length; i += 2) {
                        ans[i] = arr.get(i1++);
                        ans[i + 1] = arr2.get(i2++);
                }
                return ans;
        }
}