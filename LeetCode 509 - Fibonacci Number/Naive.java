class Solution {
        public int fib(int n) {
                int a = 0 ,b = 1;
                int c = 0;
                for(int i = 2; i < n; i++) {
                        c= a+b;
                        a = b;
                        b = c;
                }
                return c;
        }
}

public class Naive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.fib(7));
        }
}