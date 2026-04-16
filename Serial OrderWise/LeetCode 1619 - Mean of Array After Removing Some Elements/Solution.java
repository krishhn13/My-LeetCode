import java.util.*;

class Solution {
        public double trimMean(int[] arr) {
                Arrays.sort(arr);
                int elems = arr.length / 20;
                int sum = 0;
                for (int i = elems; i < arr.length - elems; i++) {
                        sum += arr[i];
                }
                return (double) sum / (arr.length - 2 * elems);
        }
}