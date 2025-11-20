import java.util.*;
class Solution {
    public boolean checkIfPangram(String sentence) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : sentence.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map.size() == 26;
    }
}
public class UsingMap {
        public static void main(String[] args) {
            Solution sol = new Solution();
            System.out.println(sol.checkIfPangram("krishn"));
        }
}
