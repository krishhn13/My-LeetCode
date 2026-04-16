class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
                int[] freq = new int[10];
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;
                for (int i : nums1) {
                        min1 = Math.min(i, min1);
                        freq[i]++;
                }
                for (int i : nums2) {
                        min2 = Math.min(i, min2);
                        freq[i]++;
                }
                for (int i = 0; i < freq.length; i++) {
                        if (freq[i] > 1)
                                return i;
                }
                if (min1 < min2) {
                        return min1 * 10 + min2;
                }
                return min2 * 10 + min1;
        }
}