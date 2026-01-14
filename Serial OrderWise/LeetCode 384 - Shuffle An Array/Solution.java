import java.util.*;

class Solution {
        int n, max;
        int min = 0;
        int[] arr, org;
        Random rand;

        public Solution(int[] nums) {
                n = nums.length;
                max = n - 1;
                arr = Arrays.copyOf(nums, n);
                org = Arrays.copyOf(nums, n);
                rand = new Random();
        }

        public int[] reset() {
                arr = Arrays.copyOf(org, n);
                return arr;
        }

        public int[] shuffle() {
                for (int i = 0; i < n; i++) {
                        int idx = rand.nextInt(max - min + 1) + min;
                        int ele = arr[idx];
                        arr[idx] = arr[i];
                        arr[i] = ele;
                }
                return arr;
        }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */