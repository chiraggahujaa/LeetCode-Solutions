class Solution {
    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0)+1);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character, Integer> e : map.entrySet())
            pq.offer(e.getValue());

        int count = 0;
        while(pq.size() > 1){
            int a = pq.poll();
            if(a == pq.peek()){
                if(a-1 > 0)
                    pq.offer(a-1);
                    
                count++;
            }
        }
        return count;
    }
}