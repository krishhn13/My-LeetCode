import java.util.*;

class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
                int mini = (int) 1e9;
                Arrays.sort(arr);
                for (int i = 1; i < arr.length; i++) {
                        mini = Math.min(mini, arr[i] - arr[i - 1]);
                }
                List<List<Integer>> ans = new ArrayList<>();
                for (int i = 1; i < arr.length; i++) {
                        if (arr[i] - arr[i - 1] == mini) {
                                List<Integer> list = new ArrayList<>();
                                list.add(arr[i - 1]);
                                list.add(arr[i]);
                                ans.add(new ArrayList<>(list));
                        }
                }
                return ans;
        }
}

public class Greedy {

        public static void main(String[] args) {
                java.util.Scanner sc = new java.util.Scanner(System.in);

                int[] arr;
                if (!sc.hasNextInt()) {
                        // Fallback demo input if nothing is provided on stdin
                        arr = new int[] { 4, 2, 1, 3 };
                } else {
                        int n = sc.nextInt();
                        arr = new int[n];
                        for (int i = 0; i < n; i++)
                                arr[i] = sc.nextInt();
                }

                java.util.List<java.util.List<Integer>> res = new Solution().minimumAbsDifference(arr);

                for (java.util.List<Integer> pair : res) {
                        System.out.println(pair.get(0) + " " + pair.get(1));
                }

                sc.close();
        }
}