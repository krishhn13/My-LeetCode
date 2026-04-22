import java.util.*;

class Solution {
    int n ;
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();
        n = queries[0].length();
        for(String str : queries) {
            for(String s : dictionary) {
                if(change(s, str) <= 2) {
                    list.add(str);
                    break;
                }
            }
        }
        return list;
    }
    private int change(String str1, String str2) {
        int change = 0;
        for(int i = 0 ; i < n; i++) {
            if(str2.charAt(i)!=str1.charAt(i)) {
                change++;
            }
            if(change > 2) {
                break;
            }
        }
        return change;
    }
}