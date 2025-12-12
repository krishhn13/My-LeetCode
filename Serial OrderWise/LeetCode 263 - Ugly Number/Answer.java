class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}

public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.isUgly(19));
        }
}
