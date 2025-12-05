import java.util.*;

class Solution {
        public List<String> letterCombinations(String digits) {
                List<String> ans = new ArrayList<>();
                if (digits.length() == 0)
                        return ans;
                int index = 0;
                String output = "";
                String[] mapping = {
                                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
                };
                solve(digits, ans, index, output, mapping);
                return ans;
        }

        void solve(String digits, List<String> ans, int index, String output, String[] mapping) {
                if (index >= digits.length()) {
                        ans.add(output);
                        return;
                }
                int number = digits.charAt(index) - '0';
                String value = mapping[number];

                for (int i = 0; i < value.length(); i += 1) {
                        output += value.charAt(i);
                        solve(digits, ans, index + 1, output, mapping);
                        output = output.substring(0, output.length() - 1);
                }
        }
}

public class LeetCode17 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.letterCombinations("23"));
        }
}
