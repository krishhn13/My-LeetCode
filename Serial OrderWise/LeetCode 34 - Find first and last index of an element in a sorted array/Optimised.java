class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        // Searching starting index
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;  // Move left to find first occurrence
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        first = ans;

        // Reset variables for second binary search
        start = 0;
        end = nums.length - 1;
        ans = -1;

        // Searching for the last element
        while (start <= end) {  // Changed from `while (start < end)`
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;  // Move right to find last occurrence
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        last = ans;

        return new int[]{first, last};
    }
}

public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.searchRange(new int[]{5,7,7,8,8,10}, 8));
        }
}
