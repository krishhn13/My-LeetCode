# 🔍 LeetCode 33: Search in Rotated Sorted Array

---

## 🎙️ The Interview Dialogue

**INTERVIEWER:** "Alright Krishan, I have got a question for you. You are given an array which is sorted and maybe or maybe not rotated. Your task is to find a given target in that array."

**Krishan:** "Of course, sir. What if the element isn't present in the array?"

**INTERVIEWER:** "Then in that case, we need to return -1."

**Krishan:** "Alright, let's unpack what we've got here:"
1.  **A sorted array** (that has been shifted).
2.  **A target** to be searched for.
3.  **The rotation factor:** The array isn't strictly monotonic, but it is "locally" sorted.

---

## 💡 Solution Strategy

### Approach 1: Linear Search
We can iterate through the array and check each element one by one.
* **Time Complexity:** $O(n)$

**INTERVIEWER:** "Can we do something better?"

**Krishan:** "Yes, sir. Since we have a sorted search space—even if it is rotated—we should use **Binary Search**."

**INTERVIEWER:** "But the array is rotated. Explain how Binary Search still applies."

**Krishan:** "Even though the array is rotated, one important observation is: **At least one half of the array is always sorted.**"



### The Logical Steps:
1.  Find the `mid` element.
2.  Check if `nums[mid]` is the target.
3.  **Identify the sorted half:** Compare `nums[low]` and `nums[mid]`.
4.  **Decide:** Check if the target lies inside the range of that sorted half.
5.  **Eliminate:** Discard the half that cannot contain the target and repeat.

---

## 📑 Algorithm Blueprint

```text
low = 0
high = n - 1

while low <= high:
    mid = low + (high - low) / 2

    if nums[mid] == target:
        return mid

    if left half sorted:
        check if target inside left range
        move accordingly
    else:
        right half sorted
        check if target inside right range
        move accordingly

return -1