class Solution {
    public int maximumGain(String s, int x, int y) {
        int points = 0;
        boolean xVisit = false, yVisit = false;
        if (x > y) {
            points += checker(s, "ab", x);
            xVisit = true;
        } else {
            points += checker(s, "ba", y);
            yVisit = true;
        }
        if (xVisit) {
            points += checker(removeAll(s, "ab"), "ba", y);
        } else {
            points += checker(removeAll(s, "ba"), "ab", x);
        }
        return points;
    }
    int checker(String s, String sub, int point) {
        Stack<Character> stack = new Stack<>();
        int score = 0;
        char first = sub.charAt(0);
        char second = sub.charAt(1);
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && ch == second) {
                stack.pop();
                score += point;
            } else {
                stack.push(ch);
            }
        }
        return score;
    }
    String removeAll(String s, String sub) {
        Stack<Character> stack = new Stack<>();
        char first = sub.charAt(0);
        char second = sub.charAt(1);
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && ch == second) {
                stack.pop(); 
            } else {
                stack.push(ch);
            }
        }
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }
}
