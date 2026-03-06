class Solution {
    public boolean checkOnesSegment(String s) {
        boolean found = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1' && !found) {
                while(i < s.length() && s.charAt(i) == '1') {
                    i++;
                }
                i--;
                found = true;
            } else if(s.charAt(i) == '1' && found) return false;
        }
        return true;
    }
}