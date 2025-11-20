import java.util.*;
class Solution {
    public boolean checkIfPangram(String sentence) {
       Set<Character>set = new HashSet<>();
       for(char c :sentence.toCharArray()) set.add(c);
       return set.size()==26;
    }
}
public class UsingSet {
        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.checkIfPangram("krishn"));
        }
}
