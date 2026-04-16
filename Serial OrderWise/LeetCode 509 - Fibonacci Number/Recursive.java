class Solution {
        public int fib(int n) {
                if(n<=1) return n;
                return fib(n-1)+fib(n-2);
        }
}

public class Recursive {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.fib(7));
        }
}
