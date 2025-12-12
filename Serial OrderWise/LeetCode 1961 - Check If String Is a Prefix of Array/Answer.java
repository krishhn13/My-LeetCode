class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder st = new StringBuilder();
        for (String ch : words) {
            st.append(ch);
            if (st.toString().equals(s)) {
                return true;
            }
            if (st.length() > s.length()) {
                return false;
            }
        }
        return false;
    }
}

public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                String s = "iloveleetcode";
                String[] arr = {"i","love","leetcode","apples"};
                System.out.println(sol.isPrefixString(s, arr));
        }
}
