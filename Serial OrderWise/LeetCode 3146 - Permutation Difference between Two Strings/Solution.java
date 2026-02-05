class Solution {
        public int findPermutationDifference(String s, String t) {
                int sum = 0, idx = 0;
                for (char c : s.toCharArray()) {
                        sum += Math.abs(t.indexOf(c) - idx);
                        idx++;
                }
                return sum;
        }
}