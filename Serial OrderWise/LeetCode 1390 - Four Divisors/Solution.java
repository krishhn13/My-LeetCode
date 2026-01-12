class Solution {
    public int sumFourDivisors(int[] nums) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i : nums) freq.put(i, freq.getOrDefault(i, 0) + 1);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i : nums) {
            map.putIfAbsent(i, new ArrayList<>());
        }
        int sum = 0;
        for(int i : map.keySet()) {
            map.put(i, find(i));
            if(map.get(i).size() == 4) {
                int l = 0;
                for(int j : map.get(i)) {
                    l+=j;
                }
                sum += l*freq.get(i); 
            }
        }
        return sum;
    }
    List<Integer> find(int num) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num%i == 0) {
                int d1 = i;
                int d2 = num/i;
                if(d1!=d2) {
                    list.add(d1);
                    list.add(d2);
                } else {
                    list.add(i);
                }
            }
        }
        return list;
    }
}