/*
================================================================
LeetCode 33 - Search in Rotated Sorted Array
================================================================

#  INTERVIEWER : Alright Krishan, I have got a question for you, you are given an array which is sorted and maybe or maybe not rotated, your task is to find a given target in that array.

# Krishan :
Of course sir. What if the element isn't present in the array?

# INTERVIEWER : Then in that case, we need to return -1.

# Krishan :
 
Alright let's unpack what we've got here :

    1. A sorted array
    2. A target to be searched for
    3. The array may be rotated but is definitely sorted

# APPROACH 1 : LINEAR SEARCH

We can iterate through the array and check each element.

### Time Complexity :
    O(n)

# INTERVIEWER :
Can we do something better?

# Krishan :

Yes sir. Since we have a sorted search space, we should
use Binary Search.

### INTERVIEWER :
But the array is rotated. Explain.

# Krishan :

Even though the array is rotated, one important observation is:

    At least one half of the array is always sorted.

So during binary search:

    1. Find mid
    2. Check which half is sorted
    3. Decide if target lies inside that sorted half
    4. Discard the other half

### ALGORITHM :

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

TIME COMPLEXITY :
    O(log n)

SPACE COMPLEXITY :
    O(1)

================================================================
*/

class Solution {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // target found
            if (nums[mid] == target) {
                return mid;
            }

            // left half sorted
            if (nums[low] <= nums[mid]) {

                // target lies inside left sorted half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // right half sorted
            else {

                // target lies inside right sorted half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // target not present
        return -1;
    }
}
