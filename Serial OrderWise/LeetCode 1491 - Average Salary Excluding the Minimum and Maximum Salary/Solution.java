class Solution {
        public double average(int[] salary) {
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;
                for (int i : salary) {
                        maxi = maxi > i ? maxi : i;
                        mini = mini > i ? i : mini;
                }
                int count = 0;
                double sum = 0;
                for (int i : salary) {
                        if (i != maxi && i != mini) {
                                sum += i;
                                count++;
                        }
                }
                return sum / count;
        }
}