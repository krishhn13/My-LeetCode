class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int mini = (int)1e9;
        int negs = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                int val = Math.abs(matrix[i][j]);
                sum += val;
                if(matrix[i][j] < 0) {
                    negs++;
                } 
                mini = Math.min(mini, val);
            }
        }
        if(negs%2 == 0) return sum;
        return sum - 2*mini;
    }
}