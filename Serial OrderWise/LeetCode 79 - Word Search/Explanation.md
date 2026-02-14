# LeetCode 79 - Word Search

## Problem Statement
Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid. The word must be constructed from sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

## Approach
This solution uses **Backtracking** with a 2D visited array to explore all possible paths from each starting cell.

## Algorithm Explanation

1. **Initialization**: Store grid dimensions and create a `visited` boolean matrix to track explored cells.

2. **Search Start**: Iterate through each cell and start a DFS when:
        - The cell matches the first character of the word
        - The cell hasn't been visited

3. **DFS/Backtracking (`find` method)**:
        - Validate boundaries and ensure the current character matches the expected word character
        - Mark the cell as visited
        - Recursively explore all 4 directions (up, down, left, right)
        - Backtrack by unmarking the cell as visited
        - Return true if any path completes the word

## Complexity
- **Time**: O(n × m × 4^L) where L is the word length
- **Space**: O(n × m) for the visited array

## Code
```java
public class Solution {
         boolean[][] visited;
         int n, m;

         public boolean exist(char[][] board, String word) {
                  n = board.length;
                  m = board[0].length;
                  visited = new boolean[n][m];
                  
                  for (int i = 0; i < n; i++) {
                                for (int j = 0; j < m; j++) {
                                         if (board[i][j] == word.charAt(0) && !visited[i][j]) {
                                                  if (find(board, word, 0, i, j)) return true;
                                         }
                                }
                  }
                  return false;
         }

         private boolean find(char[][] board, String word, int i, int r, int c) {
                  if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c] || 
                                board[r][c] != word.charAt(i)) return false;
                  
                  if (i == word.length() - 1) return true;
                  
                  visited[r][c] = true;
                  boolean found = find(board, word, i + 1, r + 1, c) ||
                                                          find(board, word, i + 1, r - 1, c) ||
                                                          find(board, word, i + 1, r, c + 1) ||
                                                          find(board, word, i + 1, r, c - 1);
                  visited[r][c] = false;
                  
                  return found;
         }
}
```
