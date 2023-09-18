class Pair{
    int i, val;
    Pair(int i, int val){
        this.i = i;
        this.val = val;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.val == b.val ? b.i - a.i : b.val - a.val
        );

        for(int i=0; i<n; i++){
            int noOfSoldiers = 0, j=0;
            while(j<m && mat[i][j] != 0){
                noOfSoldiers++;
                j++;
            }

            pq.offer(new Pair(i, noOfSoldiers));

            if(pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        int ind = 0;
        while(!pq.isEmpty()){
            res[ind++] = pq.poll().i;
        }

        reverse(res);

        return res;
    }
    private void reverse(int[] nums){
        int i=0, j=nums.length-1;
        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }
}