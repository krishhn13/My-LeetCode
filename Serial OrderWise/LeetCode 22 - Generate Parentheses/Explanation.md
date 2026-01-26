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
### Explanation

We need to generate all **well-formed** parentheses strings that contain exactly `n` pairs.

A parentheses string is valid if:
- Every `')'` has a matching `'('` before it
- Total number of `'('` and `')'` are both `n`

---

### Why This Works

The condition `close < open` guarantees that at no point does the string become invalid (i.e., we never place a `')'` without a matching `'('` available).  
By trying both choices whenever allowed, we explore all valid combinations **exactly once**.

---

### Complexity

- **Time:** `O(Cn * n)`, where `Cn` is the `n`th Catalan number (number of valid combinations). The `n` factor comes from constructing strings of length `2n`.
- **Space:** `O(n)` recursion depth (excluding the output list).

```java []
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


### Example
For `n = 3`, output is:
`["((()))","(()())","(())()","()(())","()()()"]`
