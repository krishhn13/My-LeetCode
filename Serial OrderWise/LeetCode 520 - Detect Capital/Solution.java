class Solution {
        public boolean detectCapitalUse(String word) {
                int lowerCount = 0, upperCount = 0;
                for (char ch : word.toCharArray()) {
                        if (Character.isLowerCase(ch)) {
                                lowerCount++;
                        } else {
                                upperCount++;
                        }
                }
                if (Character.isUpperCase(word.charAt(0)) && lowerCount == word.length() - 1) {
                        return true;
                }
                return lowerCount == word.length() || upperCount == word.length();
        }
}