class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if(n == 1)
            return 0;

        int finalState = (1 << n) - 1;

        boolean[][] vis = new boolean[n][finalState+1];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++){
            q.offer(new int[]{i, 1<<i});
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int x=0; x<sz; x++){
                int[] arr = q.poll();
                int u = arr[0], currBitState = arr[1];

                for(int v : graph[u]){
                    int newBitState = currBitState | (1<<v);
                    
                    if(!vis[v][newBitState]){
                        vis[v][newBitState] = true;
                        if(newBitState == finalState)
                            return count+1;
                        q.offer(new int[]{v, newBitState});
                    }

                    
                }
            }
            count++;
        }

        return -1;
    }
}