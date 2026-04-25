class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] alpha = new int[26]; 
        for(char c : licensePlate.toCharArray()) {
            if(Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                alpha[lowerChar - 'a']++;
            }
        }
        String ans = "";
        for(String word : words) {
            int[] wordFreq = new int[26];
            for(char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            boolean isValid = true;
            for(int i = 0; i < 26; i++) {
                if(alpha[i] > 0 && wordFreq[i] < alpha[i]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid && (ans.isEmpty() || word.length() < ans.length())) {
                ans = word;
            }
        }
        return ans;
    }
}
