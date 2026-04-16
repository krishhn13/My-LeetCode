class Solution {
    public int minLengthAfterRemovals(String s) {
        int aC = 0, bC = 0;
        for(char c : s.toCharArray()) {
            if(c =='a') aC++;
            else bC++;
        }
        return Math.abs(aC-bC);
    }
}