
# Wildcard Matching

## Problem Description
Given an input string `s` and a pattern `p`, implement wildcard pattern matching with support for `'?'` and `'*'` where:
- `'?'` Matches any single character.
- `'*'` Matches any sequence of characters (including the empty sequence).

The matching should cover the **entire** input string (not partial).

## Approach: Memoization (Top-Down DP)

**Intuition:** Use recursion with memoization to explore all possible matches, starting from the end of both strings.

**Algorithm:**
1. Base cases:
        - If both strings are empty → return `true`
        - If pattern is empty but string isn't → return `false`
        - If string is empty, pattern must contain only `'*'` → return `true`

2. Recursive cases (comparing from the end):
        - If characters match or pattern has `'?'` → recurse on remaining characters
        - If pattern has `'*'` → try matching zero or more characters
        - Memoize results to avoid recomputation

## Solution

```java []
class Solution {
         int[][] dp;
         
         public boolean isMatch(String s, String p) {
                  int n = s.length();
                  int m = p.length();
                  dp = new int[n][m];
                  for (int[] d : dp) {
                                Arrays.fill(d, -1);
                  }
                  return solve(s, p, n, m);
         }
         
         private boolean solve(String s, String p, int n, int m) {
                  // Both empty
                  if (n == 0 && m == 0) return true;
                  
                  // Pattern empty
                  if (m == 0) return false;
                  
                  // String empty, check if pattern has only '*'
                  if (n == 0) {
                                for (int i = 0; i < m; i++) {
                                         if (p.charAt(i) != '*') return false;
                                }
                                return true;
                  }
                  
                  // Check memoization
                  if (dp[n - 1][m - 1] != -1) {
                                return dp[n - 1][m - 1] == 1;
                  }
                  
                  boolean ans = false;
                  if (s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
                                ans = solve(s, p, n - 1, m - 1);
                  } else if (p.charAt(m - 1) == '*') {
                                ans = solve(s, p, n - 1, m) || solve(s, p, n, m - 1);
                  }
                  
                  dp[n - 1][m - 1] = ans ? 1 : 0;
                  return ans;
         }
}
```

## Complexity
- **Time:** O(n × m)
- **Space:** O(n × m) for memoization
