class Solution {
        public int countOdds(int low, int high) {
                int nms = high - low + 1;
                if (low % 2 != 0 && high % 2 != 0)
                        return (nms + 1) / 2;
                return nms / 2;
        }
}

public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.countOdds(3, 7));
        }
}
