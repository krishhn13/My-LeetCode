import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character,Integer> map = new HashMap<>();
        int idx = 0, count = 0 ;
        for(char c : word.toCharArray()) {
            if(Character.isUpperCase(c)) {
                if(map.containsKey(c)) {
                    continue;
                } else {
                    map.put(c, idx);
                }
            } else {
                map.put(c, idx);
            }
            idx++;
        }
        for(char c = 'A'; c<='Z';c++) {
            if(map.containsKey(c) && map.containsKey((char)(c+32))) {
                if(map.get(c) > map.get((char)(c+32))) count++;
            }
        }
        return count;
    }
}