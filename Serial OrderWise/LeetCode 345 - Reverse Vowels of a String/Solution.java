import java.util.*;

class Solution {
        public String reverseVowels(String s) {
                boolean[] isVowel = new boolean[s.length()];
                Stack<Character> vowels = new Stack<>();
                int idx = 0;
                for (char c : s.toCharArray()) {
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                                isVowel[idx] = true;
                                vowels.push(c);
                        } else if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                                isVowel[idx] = true;
                                vowels.push(c);
                        }
                        idx++;
                }
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                        if (isVowel[i]) {
                                str.append(vowels.pop());
                        } else {
                                str.append(s.charAt(i));
                        }
                }
                return str.toString();
        }
}