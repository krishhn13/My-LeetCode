import java.util.*;
class Solution {
    public int similarPairs(String[] words) {
        int pairs = 0;
        for(int i = 0; i < words.length-1; i++) {
            for(int j = i+1; j < words.length; j++) {
                if(count(words[i], words[j])) {
                    pairs++;
                } 
            }
        }
        return pairs;
    }
    private boolean count(String s1, String s2) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for(char c : s1.toCharArray()) {
            set1.add(c);
        }
        for(char c : s2.toCharArray()) {
            set2.add(c);
        }
        return set1.equals(set2);
    }
}