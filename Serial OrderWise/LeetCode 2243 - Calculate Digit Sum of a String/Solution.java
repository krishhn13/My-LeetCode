class Solution {
        public String digitSum(String s, int k) {
                if (s.length() <= k)
                        return s;
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < s.length(); i += k) {
                        if (i + k < s.length()) {
                                str.append(find(s.substring(i, i + k)));
                        } else {
                                str.append(find(s.substring(i)));
                        }
                }
                return digitSum(str.toString(), k);
        }

        int find(String str) {
                int sum = 0;
                for (char c : str.toCharArray()) {
                        sum += (c - '0');
                }
                return sum;
        }
}