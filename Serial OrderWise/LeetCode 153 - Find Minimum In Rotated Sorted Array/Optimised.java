class Solution {
        public int findMin(int[] arr) {
                int left = 0, right = arr.length - 1;
                while (left < right) {
                        int mid = left + (right - left) / 2;
                        if (arr[mid] > arr[right]) {
                                left = mid + 1;
                        } else {
                                right = mid;
                        }
                }
                return arr[left];
        }
}

public class Optimised {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[] arr = { 3, 4, 5, 1, 2 };
                System.out.println(sol.findMin(arr));
        }
}
