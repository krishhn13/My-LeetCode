class Solution {
        public int countAsterisks(String s) {
                int ast = 0, count = 0;
                for (int i = 0; i < s.length(); i++) {
                        if (s.charAt(i) == '*' && count % 2 == 0) {
                                ast++;
                        } else if (s.charAt(i) == '|')
                                count++;
                }
                return ast;
        }
}

public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.countAsterisks("l|*e*et|c**o|*de|"));
        }
}
