import java.util.*;

class Solution {
        public boolean isValid(String s) {
                if (s.length() <= 1)
                        return false;
                Stack<Character> stack = new Stack<>();
                for (char c : s.toCharArray()) {
                        if (c == '(' || c == '{' || c == '[') {
                                stack.push(c);
                        } else {
                                if (stack.isEmpty())
                                        return false;
                                char top = stack.pop();
                                if ((c == ')' && top != '(') ||
                                                (c == '}' && top != '{') ||
                                                (c == ']' && top != '[')) {
                                        return false;
                                }
                        }
                }
                return stack.isEmpty();
        }
}

public class LeetCode20 {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isValid("[]{}{{(}}"));
        }
}
