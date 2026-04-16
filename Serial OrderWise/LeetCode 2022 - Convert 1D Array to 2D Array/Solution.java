class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n!=original.length) return new int[][]{};
        int k = 0;
        int[][] num = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(k<original.length){
                    num[i][j] = original[k];
                    k++;
                }
            }
        }
        return num;
    }
}