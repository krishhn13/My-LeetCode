class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        for (int i = 0; i <= s.length() - k; i++) {
            String substring = s.substring(i, i + k);
            char firstChar = substring.charAt(0);
            boolean allSame = true;
            for (int j = 1; j < k; j++) {
                if (substring.charAt(j) != firstChar) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                if ((i == 0 || s.charAt(i - 1) != firstChar) && 
                    (i + k == s.length() || s.charAt(i + k) != firstChar)) {
                    return true;
                }
            }
        }
        return false;
    }
}