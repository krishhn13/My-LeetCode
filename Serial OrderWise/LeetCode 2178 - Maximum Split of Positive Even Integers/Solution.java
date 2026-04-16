import java.util.*;

class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
                List<Long> list = new ArrayList<>();
                if (finalSum % 2 != 0)
                        return list;
                long num = 2;
                while (num <= finalSum) {
                        list.add(num);
                        finalSum -= num;
                        num += 2;
                }
                if (finalSum > 0) {
                        long last = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(finalSum + last);
                }
                return list;
        }
}