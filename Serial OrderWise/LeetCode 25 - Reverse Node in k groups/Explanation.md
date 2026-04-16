# LeetCode 25 — Reverse Nodes in *k*-Group (Explanation)

## Problem Summary
Given the head of a linked list, reverse the nodes of the list *k* at a time and return the modified list.  
If the number of nodes remaining is less than *k*, those nodes must remain in the same order.

---

## Key Idea
Process the list in chunks of size *k*:

1. **Check if a full group of `k` nodes exists** starting from `head`.
        - If not, return `head` as-is (no reversal).
2. **Reverse exactly `k` nodes** using the standard iterative reversal technique.
3. **Recursively solve the rest** of the list starting from the node after the reversed group.
4. **Connect the reversed group with the result of recursion**.

---

## Step-by-Step Based on the Code

### 1) Handle empty list
```java []
if (head == null)
         return null;
```
If the list is empty, nothing to reverse.

---

### 2) Verify there are at least `k` nodes to reverse
```java []
ListNode temp = head;
int count = 0;
while (count < k) {
         if (temp == null)
                  return head;
         temp = temp.next;
         count++;
}
```
This loop ensures a complete group of size `k` exists.

- `temp` moves forward `k` steps.
- If it becomes `null` before completing `k` steps, it means fewer than `k` nodes remain → return `head` unchanged.

---

### 3) Reverse the next `k` nodes
```java []
ListNode prev = null;
temp = head;
ListNode forward = null;
count = 0;
while (count < k) {
         forward = temp.next;
         temp.next = prev;
         prev = temp;
         temp = forward;
         count++;
}
```

Pointers used:
- `prev`: becomes the new head of the reversed group.
- `temp`: current node being processed.
- `forward`: stores the next node so the list isn’t lost after changing links.

After this loop:
- `prev` points to the reversed group’s head.
- `forward` (same as `temp`) points to the start of the remaining list.
- The original `head` is now the **tail** of this reversed group.

---

### 4) Connect reversed group to the rest (recursion)
```java []
head.next = reverseKGroup(forward, k);
return prev;
```

- `head` is now the tail of the reversed group, so its `next` must point to the result of reversing the remaining list.
- Return `prev` because it is the new head after reversing this group.

---

## Why It Works
- The **group check** prevents reversing partial groups.
- The **local reversal** correctly reverses exactly `k` nodes.
- **Recursion** handles the remaining part of the list with the same logic.
- Connecting via `head.next = ...` preserves correct ordering across groups.

---

## Complexity
- **Time:** `O(n)` — each node is visited a constant number of times.
- **Space:** `O(n/k)` recursion depth (worst case `O(n)` if `k = 1`), excluding the linked list itself.

---

## Example
Input: `1 -> 2 -> 3 -> 4 -> 5`, `k = 2`  
Output: `2 -> 1 -> 4 -> 3 -> 5`

- Reverse `(1,2)` → `2,1`
- Reverse `(3,4)` → `4,3`
- Remaining `(5)` is less than `k` → unchanged
- Connect all parts
