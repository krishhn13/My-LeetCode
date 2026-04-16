class Solution {
        public int maxDistance(int[] colors) {
                int l = 0, r = colors.length - 1;
                while (r > l) {
                        if (colors[l] != colors[r]) {
                                break;
                        }
                        r--;
                }
                int left = 0, right = colors.length - 1;
                while (left < right) {
                        if (colors[left] != colors[right])
                                break;
                        left++;
                }
                return Math.max(r - l, right - left);
        }
}