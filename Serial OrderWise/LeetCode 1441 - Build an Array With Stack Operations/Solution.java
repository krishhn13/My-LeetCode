import java.util.*;
class Solution {
        public List<String> buildArray(int[] target, int n) {
                List<String> list = new ArrayList<>();
                int el = 0;
                for (int i = 1; i <= n; i++) {
                        if (el == target.length) {
                                break;
                        }
                        if (i == target[el]) {
                                list.add("Push");
                                el++;
                        } else {
                                list.add("Push");
                                list.add("Pop");
                        }
                }
                return list;
        }
}