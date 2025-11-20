import java.util.*;

class Solution {
        public List<String> generateParenthesis(int n) {
                List<String> list = new ArrayList<>();
                generate("", n, 0, 0, list);
                return list;
        }

        void generate(String str, int n, int open, int close, List<String> list) {
                if (str.length() == 2 * n) {
                        list.add(str);
                        return ;
                }
                if(open < n) {
                        generate(str+"(", n, open+1, close, list);
                } 
                if(close < open) {
                        generate(str+")", n, open, close+1, list);
                }
        }
}

public class Backtracking {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.generateParenthesis(5));
        }
}
