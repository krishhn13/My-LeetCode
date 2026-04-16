class Solution {
        public String longestPalindrome(String s) {
                if (s.length() <= 1)
                        return s;
                String ans = s.substring(0, 1);
                for (int i = 0; i < s.length(); i++) {
                        String a = expand(s, i, i);
                        String b = expand(s, i, i + 1);
                        if (ans.length() < a.length())
                                ans = a;
                        if (ans.length() < b.length())
                                ans = b;
                }
                return ans;
        }

        private String expand(String str, int left, int right) {
                while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                        left--;
                        right++;
                }
                return str.substring(left + 1, right);
        }
}