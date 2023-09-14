class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new  ArrayDeque<>();

        q.offer(0);
        vis[0] = true;

        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int x=0; x<size; x++){
                int i = q.poll();
                if(i >= n-1)
                    return count;

                for(int k=1; k<=nums[i]; k++){
                    if(i+k<n && !vis[i+k]){
                        q.offer(i+k);
                        vis[i+k] = true;
                    }
                }
            }
            count ++;
        }

        return -1;
    }
}