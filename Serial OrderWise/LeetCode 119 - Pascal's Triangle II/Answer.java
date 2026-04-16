import java.util.*;
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < rowIndex+1;i++) {
            list.add(ncR(rowIndex,i));
        }
        return list;
    }
    int ncR(int n, int r){
        long res = 1;
        for(int i = 0;i<r;i++) {
            res = res* (n-i);
            res = res/(i+1);
        }
        return (int)res;
    }
}
public class Answer {
        public static void main(String[] args) {
                Solution sol = new Solution();
                System.out.println(sol.getRow(5));
        }
}
