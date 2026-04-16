class Solution {
        public String longestPrefix(String s) {
                int last = build(s);
                return s.substring(0, last);
        }

        private int build(String str) {
                int[] lps = new int[str.length()];
                int i = 1, len = 0;
                while (i < str.length()) {
                        if (str.charAt(i) == str.charAt(len)) {
                                len++;
                                lps[i] = len;
                                i++;
                        } else if (len > 0) {
                                len = lps[len - 1];
                        } else {
                                i++;
                        }
                }
                return lps[lps.length - 1];
        }
}