class Solution {
        public String shortestPalindrome(String s) {
                String rev = new StringBuilder(s).reverse().toString();
                String patt = s + "#" + rev;
                int[] lps = build(patt);
                int palLen = lps[lps.length - 1];
                return rev.substring(0, s.length() - palLen) + s;
        }

        private int[] build(String s) {
                int[] lps = new int[s.length()];
                int i = 1, len = 0;
                while (i < s.length()) {
                        if (s.charAt(i) == s.charAt(len)) {
                                len++;
                                lps[i] = len;
                                i++;
                        } else if (len > 0) {
                                len = lps[len - 1];
                        } else {
                                i++;
                        }
                }
                return lps;
        }
}