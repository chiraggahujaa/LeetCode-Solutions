class Solution {
    public boolean canFinish(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDeg = new int[n];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, y -> new ArrayList<>()).add(v);
            inDeg[v]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++)
            if(inDeg[i] == 0)
                q.offer(i);

        int courses = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            courses++;

            for(int v : adj.getOrDefault(u, new ArrayList<>())){
                inDeg[v]--;
                if(inDeg[v] == 0)
                    q.offer(v);
            }
        }

        return courses == n;
    }
}