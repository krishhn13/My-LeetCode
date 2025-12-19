class Pair {
        int node, time;

        Pair(int time, int node) {
                this.time = time;
                this.node = node;
        }
}

class Solution {
        Map<Integer, List<Pair>> map = new HashMap<>();

        void addEdge(int src, int des, int time) {
                map.putIfAbsent(src, new ArrayList<>());
                map.putIfAbsent(des, new ArrayList<>());
                map.get(src).add(new Pair(time, des));
                map.get(des).add(new Pair(time, src));
        }

        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
                List<Integer> list = new ArrayList<>();
                for (int[] ar : meetings) {
                        addEdge(ar[0], ar[1], ar[2]);
                }
                int[] ans = findKnownPeople(firstPerson, n);
                for (int i = 0; i < ans.length; i++) {
                        if (ans[i] != (int) 1e9) {
                                list.add(i);
                        }
                }
                return list;
        }

        int[] findKnownPeople(int src, int n) {
                int[] dist = new int[n];
                Arrays.fill(dist, (int) 1e9);
                PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
                dist[0] = 0;
                dist[src] = 0;
                pq.add(new Pair(0, 0));
                pq.add(new Pair(0, src));
                while (!pq.isEmpty()) {
                        Pair p = pq.poll();
                        int time = p.time;
                        int node = p.node;
                        if (time > dist[node])
                                continue;
                        if (!map.containsKey(node))
                                continue;
                        for (Pair pp : map.get(node)) {
                                int t2 = pp.time;
                                int n2 = pp.node;
                                if (t2 >= time && t2 < dist[n2]) {
                                        dist[n2] = t2;
                                        pq.add(new Pair(t2, n2));
                                }
                        }
                }
                return dist;
        }
}