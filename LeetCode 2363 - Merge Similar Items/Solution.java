class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int[] i : items1) {
            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
        }
        for(int[] i : items2) {
            map.put(i[0],map.getOrDefault(i[0],0)+i[1]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i : map.keySet()) {
            List<Integer> l = new ArrayList<>();
            l.add(i);l.add(map.get(i));
            list.add(l);
        }
        return list;
    }
}