class Solution {
    public boolean checkZeroOnes(String s) {
        int zeroes = 0, ones = 0, maxi = 0, maxxi = 0;
        for(int i = 0 ; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                while(i < s.length() && s.charAt(i) == '0') {
                    zeroes++;
                    i++;
                }
                i--;
                maxi = Math.max(zeroes, maxi);
                zeroes = 0;
            } else if(s.charAt(i) == '1') {
                while(i < s.length() && s.charAt(i) == '1') {
                    ones++;
                    i++;
                }
                i--;
                maxxi = Math.max(ones, maxxi);
                ones = 0;
            }
        }
        return maxxi > maxi;
    }
}