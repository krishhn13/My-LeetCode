import java.util.*;
public class Solution {
        public List<List<Integer>> combine(int n, int k) {
                List<List<Integer>> list = new ArrayList<>();
                generate(list, 1, new ArrayList<>(), k, n);
                return list;
        }
        void generate(List<List<Integer>> list, int start, List<Integer> arr, int k, int n) {
                if(arr.size() == k) {
                        list.add(new ArrayList<>(arr));
                        return ;
                }
                for(int i = start; i <= n; i++) {
                        arr.add(i);
                        generate(list, i+1, arr, k, n);
                        arr.remove(arr.size()-1);
                }
        }
}
