class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int zeroes = 0, ones = 0, maxi = 0;
        int n = s.length();
        int prev = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (!found) {
                    found = true;
                    prev = i;
                    zeroes = 0;
                }
                if (ones > 0) { 
                    zeroes = 0;
                    ones = 0;
                    prev = i;
                }
                zeroes++;
            }
            else if (found) {  
                ones++;
                if (ones <= zeroes) {
                    maxi = Math.max(maxi, ones * 2);
                }
                if (ones > zeroes) { 
                    found = false;
                    zeroes = 0;
                    ones = 0;
                }
            }
        }
        return maxi;
    }
}