class Solution {
        public String getSmallestString(int n, int k) {
                StringBuilder sb = new StringBuilder();
                while (n > 0) {
                        int start = 26;
                        while (k - start < n - 1) {
                                start--;
                        }
                        sb.append((char) ('a' + start - 1));
                        k -= start;
                        n -= 1;
                }
                return sb.reverse().toString();
        }
}