/**
 * Solves the climbing stairs problem using top-down dynamic programming (memoization).
 * 
 * The problem: Given n stairs, you can climb 1 or 2 stairs at a time.
 * Find the total number of distinct ways to reach the top.
 * 
 * Approach: Memoization (Top-Down DP)
 * - Base cases: If position equals n, return 1 (one way to reach top). 
 *               If position exceeds n, return 0 (invalid path).
 * - For each position i, the number of ways is the sum of ways from (i+1) and (i+2).
 * - Uses a dp array to store already computed results, avoiding redundant calculations.
 * 
 * Time Complexity: O(n) - each stair is computed once and memoized.
 * Space Complexity: O(n) - for the dp array and recursive call stack.
 * 
 * @param n the total number of stairs to climb
 * @return the total number of distinct ways to reach the top
 * 
 * Example: climbStairs(4) returns 5
 *          (paths: 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2)
 * 
 * Note: This implementation can also be solved using bottom-up DP for better space efficiency.
 */