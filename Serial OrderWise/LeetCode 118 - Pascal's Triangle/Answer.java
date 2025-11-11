import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>l = new ArrayList<>();
        for(int i = 0;i < numRows;i++) {
            List<Integer> list = new ArrayList<>();
            for(int c = 0; c<=i;c++) {
                list.add(findNcR(i,c));
            }
            l.add(list);
        }
        return l;
    }
    int findNcR(int n, int r){
        int res = 1;
        for(int i = 0;i<r;i++) {
            res = res * (n-i);
            res = res/(i+1);
        }
        return res;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.generate(9));
        }
}
