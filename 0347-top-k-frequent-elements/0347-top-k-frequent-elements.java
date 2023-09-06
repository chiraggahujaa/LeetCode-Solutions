class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int el : nums)
            map.put(el, map.getOrDefault(el, 0)+1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b)
        ); // min heap

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int el = e.getKey();
            pq.offer(el);

            while(pq.size() > k)
                pq.poll();
        }

        int[] res = new int[k];
        int ind = 0;
        while(!pq.isEmpty()){
            res[ind++] = pq.poll();
        }

        return res;
    }
}