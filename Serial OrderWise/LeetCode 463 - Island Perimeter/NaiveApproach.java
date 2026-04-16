class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        int n = grid.length, m = grid[0].length;
        for(int i = 0 ; i < n;i++) {
                for(int j = 0; j < m; j++) {
                        if(grid[i][j] == 1) {
                                int prob = 4;
                                // Up
                                if(i > 0  && grid[i-1][j] == 1) {
                                        prob-=1;
                                } 
                                // Left
                                if(j > 0 && grid[i][j-1] == 1) {
                                        prob-=1;
                                }
                                // Down
                                if(i < n-1 && grid[i+1][j] == 1) {
                                        prob-=1;
                                }
                                // Rigth
                                if(j < m-1 && grid[i][j+1] == 1) {
                                        prob-=1;
                                }
                                peri+=prob;
                        } 
                }
        }
        return peri;
    }
}

public class NaiveApproach {
        public static void main(String[] args) {
                Solution sol = new Solution();
                int[][] arr = {
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}    
                };
                System.out.println(sol.islandPerimeter(arr));
        }
}
