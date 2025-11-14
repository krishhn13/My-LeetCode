class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] arr = new int[n][n];
        for(int i = 0; i<queries.length;i++) {
            add(queries[i][0],queries[i][1],queries[i][2],queries[i][3],arr);
        }
        return arr;
    }
    private void add(int startRow , int startCol, int endRow, int endCol, int[][] n) {
        for(int i = startRow; i <= endRow; i++) {
            for(int j = startCol; j <= endCol;j++) {
                n[i][j]++;
            }
        } 
    }
}
public class BruteForce {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[][] arr = sol.rangeAddQueries(3, new int[][]{{1,1,2,2},{0,0,1,1}});
                for(int i =0 ;i<arr.length;i++) {
                        for(int j = 0;j<arr[0].length;j++) {
                                System.out.print(arr[i][j] + " ");
                        }
                }
        }
}
