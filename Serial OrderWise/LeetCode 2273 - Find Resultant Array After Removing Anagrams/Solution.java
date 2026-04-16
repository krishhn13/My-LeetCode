import java.util.*;

class Solution {
        public List<String> removeAnagrams(String[] words) {
                List<String> word = new ArrayList<>();
                for (String s : words) {
                        char[] chars = s.toCharArray();
                        // Arrays.sort(chars);q
                        // System.out.print
                        word.add(new String(chars));
                }
                return check(word);
        }

        List<String> check(List<String> word) {
                if (word.size() == 1)
                        return word;
                int index = indexing(word);
                if (index == -1)
                        return word;
                word.remove(index);
                return check(word);
        }

        int indexing(List<String> word) {
                for (int i = 0; i < word.size() - 1; i++) {
                        if (isAnagram(word.get(i), word.get(i + 1))) {
                                return i + 1;
                        }
                }
                return -1;
        }

        boolean isAnagram(String s1, String s2) {
                if (s1.length() != s2.length())
                        return false;
                char[] a = s1.toCharArray();
                char[] b = s2.toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                return Arrays.equals(a, b);
        }
}