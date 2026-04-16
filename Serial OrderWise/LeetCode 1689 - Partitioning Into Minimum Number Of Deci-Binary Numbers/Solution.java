class Solution {
        public int minPartitions(String n) {
                int maxi = 0;
                for (char c : n.toCharArray()) {
                        maxi = Math.max(c - '0', maxi);
                }
                return maxi;
        }
}