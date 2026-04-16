class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        for(char c : word.toCharArray()) {
            if(Character.isLowerCase(c)) lower[c-'a']++;
            else upper[c-'A']++;
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(lower[i]!=0 && upper[i]!=0) {
                count++;
            }
        }
        return count;
    }
}