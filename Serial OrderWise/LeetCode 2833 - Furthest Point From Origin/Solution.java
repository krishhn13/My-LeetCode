class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int countL = 0, countR = 0;
        int n = moves.length();
        for(char c : moves.toCharArray()) {
            if(c == 'L') {
                countL++;
            } else if(c == 'R') {
                countR++;
            }
        }
        int blanks = n - countL - countR;
        if(countL == countR) {
            return blanks;
        }
        return blanks + Math.abs(countL-countR);
    }
}