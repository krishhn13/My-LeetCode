class Solution {
        public int longestMountain(int[] arr) {
                int n = arr.length;
                if (n < 3)
                        return 0;
                int i = 1;
                int longest = 0;

                while (i < n - 1) {
                        boolean isPeak = ((arr[i] > arr[i - 1]) && (arr[i] > arr[i + 1]));
                        if (isPeak) {
                                int left = i;
                                int right = i;
                                while (left > 0 && arr[left] > arr[left - 1]) {
                                        left--;
                                }
                                while (right < n - 1 && arr[right] > arr[right + 1]) {
                                        right++;
                                }

                                int currLen = right - left + 1;
                                longest = Math.max(longest, currLen);
                                i = right;
                        } else {
                                i++;
                        }
                }

                return longest;
        }
}