Imagine this as if
        digits[] = [1,2,3]      
        represents the integer 123.
To increment the integer by one, we can start from the last digit and move towards the first digit, handling any carry that results from the addition.

But if the last digit is 9, adding one would result in a carry-over to the next digit. This process continues until there are no more carries left or we reach the most significant digit. follows:     
1. Start from the last digit of the array.
2. Add one to the current digit.
3. If the result is less than 10, we can simply return the array as no further carry is needed.
4. If the result is 10, set the current digit to 0 and move to the next digit to the left, repeating the process.
Here's a Java implementation of the above logic:        
```java []
public int[] plusOne(int[] digits) {
    int n = digits.length;
    
    // Traverse the array from the last digit to the first
    for (int i = n - 1; i >= 0; i--) {
        // Add one to the current digit
        digits[i]++;
        
        // If the digit is less than 10, we are done
        if (digits[i] < 10) {
            return digits;
        }
        
        // If the digit is 10, set it to 0 and continue to the next digit
        digits[i] = 0;
    }
    
    // If we reach here, it means we had a carry from the most significant digit
    // We need to create a new array with an additional digit
    int[] newDigits = new int[n + 1];
    newDigits[0] = 1; // Set the most significant digit to 1
    return newDigits; // The rest are already initialized to 0
}       


