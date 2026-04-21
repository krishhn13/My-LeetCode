import java.util.*;
class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) return false;
            int[] freq = new int[26];
            int[] freq2 = new int[26];
            for (char c : s1.toCharArray()) freq[c - 'a']++;
            for (int i = 0; i < s1.length(); i++) {
                freq2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(freq, freq2)) return true;
            int j = s1.length();
            for (int i = j; i < s2.length(); i++) {
                freq2[s2.charAt(i - j) - 'a']--;
                freq2[s2.charAt(i) - 'a']++;
                if (Arrays.equals(freq, freq2)) return true;
            }
            return false;
        }
    }