class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap
        for(int el : nums){
            pq.offer(el);
            while(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}