import java.util.*;
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for(int i = 0;i < n;i++) {
            map.putIfAbsent(groupSizes[i], new ArrayList<>());
            map.get(groupSizes[i]).add(i);
        }
 
        List<List<Integer>> ans = new ArrayList<>();
        for(int group : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for(int key : map.get(group)) {
                if(temp.size() == group) {
                    ans.add(new ArrayList<>(temp));
                    temp = new ArrayList<>();
                }
                temp.add(key);
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}