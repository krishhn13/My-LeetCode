import java.util.*;

class Solution {
        public boolean checkValidString(String s) {
                Stack<Integer> leftParen = new Stack<>();
                Stack<Integer> star = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                        char c = s.charAt(i);
                        if (c == '(') {
                                leftParen.push(i);
                        } else if (c == '*') {
                                star.push(i);
                        } else if (c == ')') {
                                if (!leftParen.isEmpty()) {
                                        leftParen.pop();
                                } else if (!star.isEmpty()) {
                                        star.pop();
                                } else {
                                        return false;
                                }
                        }
                }
                while (!leftParen.isEmpty() && !star.isEmpty()) {
                        if (leftParen.pop() > star.pop()) {
                                return false;
                        }
                }
                return leftParen.isEmpty();
        }
}
