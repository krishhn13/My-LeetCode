class Solution {
        public int findMin(int[] nums) {
                int left = 0;
                int right = nums.length - 1;
                if (nums[left] < nums[right]) {
                        return nums[left];
                }
                while (left <= right) {
                        int mid = left + (right - left) / 2;
                        if (nums[mid] > nums[right]) {
                                left = mid + 1;
                        } else if (nums[mid] < nums[right]) {
                                right = mid;
                        } else {
                                right--;
                        }
                }
                return nums[left];
        }
}

public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = { 2, 2, 2, 0, 1 };
                System.out.println(sol.findMin(arr));
        }
}
