## Valid Parentheses — Explanation (LeetCode style)

### Intuition
A closing bracket must match the most recent unmatched opening bracket. This “last opened, first closed” behavior is exactly what a **stack** provides.

### Approach
- Traverse the string character by character.
- If the character is an opening bracket `(`, `{`, `[`, push it onto the stack.
- Otherwise, it’s a closing bracket:
  - If the stack is empty, there’s nothing to match → invalid.
  - Pop the stack top and check if it matches the closing bracket:
    - `)` must match `(`
    - `}` must match `{`
    - `]` must match `[`
  - If it doesn’t match → invalid.
- After processing all characters, the string is valid only if the stack is empty (no unmatched openings left).

### Why this works
The stack ensures we always match a closing bracket with the most recent opening bracket that hasn’t been matched yet. Any mismatch or premature closing immediately proves the string invalid.

### Complexity
- **Time:** `O(n)` — each character is pushed/popped at most once.
- **Space:** `O(n)` — in the worst case (all opening brackets), the stack holds `n` characters.

### Solution 
```java []
class Solution {
    public boolean isValid(String s) {
        if (s.length() <= 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
```