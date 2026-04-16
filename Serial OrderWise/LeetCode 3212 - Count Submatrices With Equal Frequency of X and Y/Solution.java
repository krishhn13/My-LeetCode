class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        // x = 1
        // y = -1
        // '.' = 0
        int n = grid.length, m = grid[0].length;
        int[][] temp = new int[n][m];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0 ; j < m; j++) {
                if(grid[i][j] == 'X') {
                    temp[i][j] = 1;
                } else if(grid[i][j] == 'Y') {
                    temp[i][j] = -1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        int[][] pre = new int[n][m];
        pre[0][0] = temp[0][0];
        for(int i = 0; i < n; i++) {
            for(int j = 0 ;j < m; j++) {
                if(i==0 && j == 0) {
                    continue;
                } else if(i==0) {
                    pre[i][j] = pre[i][j-1] + temp[i][j];
                } else if(j == 0) {
                    pre[i][j] = pre[i-1][j] + temp[i][j];
                } else {
                    pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + temp[i][j];
                }
            }
        } 
        int[][] countX = new int[n][m];
        countX[0][0] = (temp[0][0] == 1 ? 1 : 0);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) continue;
                int val = (temp[i][j] == 1 ? 1 : 0);
                if(i == 0) {
                    countX[i][j] = countX[i][j-1] + val;
                } else if(j == 0) {
                    countX[i][j] = countX[i-1][j] + val;
                } else {
                    countX[i][j] = countX[i-1][j] + countX[i][j-1] - countX[i-1][j-1] + val;
                }
            }
        }
        int count = 0;
        for(int i = 0 ;i < n; i++) {
            for(int j = 0 ;j < m;j++) {
                if(pre[i][j] == 0 && countX[i][j] > 0) {
                    count++;
                }
            }
        }
        /*
        for(int i = 0 ;i < n; i++) {
            for(int j = 0 ;j < m;j++) {
                if(pre[i][j] == 0 && checkForOnes(i, j, temp)) {
                    count++;
                }
            }
        }*/
        return count;
    }
    /*
        private boolean checkForOnes(int row, int col, int[][] arr) {
        for(int i = 0 ;i <= row; i++) {
            for(int j = 0; j <= col; j++) {
                if(arr[i][j] == 1) return true;
            }
        }
        return false;
    }
        */
}