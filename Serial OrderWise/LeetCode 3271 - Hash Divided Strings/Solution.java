public class Solution {
        public String stringHash(String s, int k) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i += k) {
                        String str = s.substring(i, i + k);
                        sb.append((char) (97 + addValues(str)));
                }
                return sb.toString();
        }

        int addValues(String str) {
                int sum = 0;
                for (char c : str.toCharArray()) {
                        sum += c - 'a';
                }
                return sum % 26;
        }
}