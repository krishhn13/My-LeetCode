Given the problem of finding the number of unique paths from the top-left corner to the bottom-right corner of an m x n grid, we can approach the solution using dynamic programming.

But first, let's understand the problem. You can only move either down or right at any point in time. The goal is to determine how many unique paths exist from the start point (0,0) to the endpoint (m-1,n-1).

And also why can't we use a simple combinatorial approach directly?

A combinatorial approach can be used to find the number of unique paths by calculating the number of ways to arrange a sequence of moves. Specifically, to reach the bottom-right corner from the top-left corner in an m x n grid, you need to make (m-1) down moves and (n-1) right moves. The total number of moves is (m-1) + (n-1) = m + n - 2. The number of unique paths can be calculated using the binomial coefficient:C(m+n-2, m-1) = (m+n-2)! / ((m-1)! * (n-1)!)
However, calculating factorials for large numbers can lead to overflow issues and may not be efficient. Therefore, a dynamic programming approach is often preferred for its clarity and efficiency.
To solve this problem using dynamic programming, we can create a 2D array (or grid) where each cell represents the number of unique paths to reach that cell from the starting point.
Here’s a step-by-step explanation of the dynamic programming approach:
1. **Initialization**: Create a 2D array `dp` of size m x n, where `dp[i][j]` will hold the number of unique paths to reach cell (i, j). Initialize the first row and first column to 1, since there is only one way to reach any cell in the first row (by moving right) or in the first column (by moving down).
2. **Filling the DP Table**: Iterate through the grid starting from cell (1, 1). For each cell (i, j), the number of unique paths to reach that cell can be calculated as the sum of the unique paths to reach the cell directly above it (i-1, j) and the cell directly to the left of it (i, j-1). This is because you can only arrive at (i, j) from either of these two cells.
   - Formula: `dp[i][j] = dp[i-1][j] + dp[i][j-1]`
3. **Result**: The value in the bottom-right cell `dp[m-1][n-1]` will give us the total number of unique paths from the top-left corner to the bottom-right corner of the grid.
Here is a sample implementation in Java:
```java[]
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    
    // Initialize the first row and first column
    for (int i = 0; i < m; i++) {
        dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        dp[0][j] = 1;
    }
    
    // Fill the DP table
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    
    // The bottom-right cell contains the number of unique paths
    return dp[m-1][n-1];
}
```
This approach has a time complexity of O(m*n) and a space complexity of O(m*n) due to the 2D array used for storing the number of unique paths. However, we can optimize the space complexity to O(n) by using a single array to store the current row's values, as we only need the current and previous row to compute the number of unique paths.
Here is the optimized version:
```java[]
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    
    // Initialize the first row
    for (int j = 0; j < n; j++) {
        dp[j] = 1;
    }
    
    // Fill the DP array
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[j] += dp[j-1];
        }
    }
    
    // The last element contains the number of unique paths
    return dp[n-1];
}

```
This approach has a time complexity of O(m*n) and a space complexity of O(n), making it more efficient in terms of space usage while still effectively calculating the number of unique paths in the grid.