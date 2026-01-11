import java.util.*;
public class Solution {
        public int residuePrefixes(String s) {
                int ans = 0;
                int len = 0;
                Set<Character> set = new HashSet<>();
                for (char c : s.toCharArray()) {
                        ++len;
                        set.add(c);
                        if (set.size() == len % 3) {
                                ans++;
                        }
                }
                return ans;
        }
}
