public class Solution {
    void addEdge(int src, int des, Map<Integer,List<Integer>> map ) {
        map.putIfAbsent(src,new ArrayList<>());
        map.get(src).add(des);
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        int V = graph.length;
        int[] check = new int[V];
        int[] inDeg = new int[V];
        for(int u = 0; u < V; u++) {
            for(int v : graph[u]) {
                addEdge(v, u, map);
                inDeg[u]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ;i <V;i++){
            if(inDeg[i] == 0) {
                q.add(i);
            }
        }
        while(!q.isEmpty()) {
            int val = q.poll();
            check[val] = 1;
            for(int i : map.getOrDefault(val,new ArrayList<>())) {
                inDeg[i]--;
                if(inDeg[i] ==0) q.add(i);
            }
        }
        for(int i = 0;i<V;i++) {
            if(check[i]==1) {
                list.add(i);
            }
        }
        return list;
    }
}