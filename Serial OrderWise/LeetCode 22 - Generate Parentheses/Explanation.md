/**
 * Generates all combinations of {@code n} pairs of well-formed parentheses.
 *
 * <p><b>LeetCode 22: Generate Parentheses</b></p>
 *
 * <p><b>Idea (Backtracking)</b>:
 * Build the string one character at a time while maintaining:
 * <ul>
 *   <li>{@code open}: number of '(' used so far</li>
 *   <li>{@code close}: number of ')' used so far</li>
 * </ul>
 * At any point, we may:
 * <ul>
 *   <li>Add '(' if {@code open < n}</li>
 *   <li>Add ')' if {@code close < open} (to keep the string valid)</li>
 * </ul>
 * When the current string length reaches {@code 2 * n}, it is a complete valid
 * combination and is added to the result list.
 *
 * <p><b>Why it works</b>:
 * The constraint {@code close < open} ensures we never place a ')' that would
 * make the prefix invalid, so every completed string is well-formed. Exploring
 * both choices where allowed enumerates all valid combinations exactly once.
 *
 * <p><b>Complexity</b>:
 * <ul>
 *   <li>Time: {@code O(Cn * n)}, where {@code Cn} is the nth Catalan number (number of valid strings),
 *       and {@code n} factor comes from building strings of length {@code 2n}.</li>
 *   <li>Space: {@code O(n)} recursion depth (excluding output storage).</li>
 * </ul>
 *
 * @param n number of pairs of parentheses
 * @return list of all well-formed parentheses combinations of size {@code n}
 */
```java
class Solution {
        public List<String> generateParenthesis(int n) {
                List<String> res = new ArrayList<>();
                backtrack(n, 0, 0, new StringBuilder(), res);
                return res;
        }

        private void backtrack(int n, int open, int close, StringBuilder sb, List<String> res) {
                if (sb.length() == 2 * n) {
                        res.add(sb.toString());
                        return;
                }

                if (open < n) {
                        sb.append('(');
                        backtrack(n, open + 1, close, sb, res);
                        sb.deleteCharAt(sb.length() - 1);
                }

                if (close < open) {
                        sb.append(')');
                        backtrack(n, open, close + 1, sb, res);
                        sb.deleteCharAt(sb.length() - 1);
                }
        }
}
```
### Intuition
To generate only **valid** parentheses strings, we build the answer one character at a time and never allow an invalid prefix.

### Approach (Backtracking)
Keep track of:
- `open`: how many `'('` we have placed
- `close`: how many `')'` we have placed

Rules:
- We can add `'('` if `open < n`
- We can add `')'` if `close < open` (so we never close more than we open)

When the current string length becomes `2 * n`, it is a complete valid combination.

### Algorithm
1. Start DFS/backtracking with an empty string, `open = 0`, `close = 0`.
2. If length is `2n`, add it to results.
3. If `open < n`, append `'('` and recurse.
4. If `close < open`, append `')'` and recurse.
5. Backtrack by removing the last appended character.

### Example
For `n = 3`, output is:
`["((()))","(()())","(())()","()(())","()()()"]`

### Complexity
- **Time:** `O(Cn * n)`, where `Cn` is the `n`th Catalan number (number of valid combinations)
- **Space:** `O(n)` for recursion depth (excluding the output)