class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        int t = 0;

        for(int[] course : courses){
            int dur = course[0];
            int maxTime = course[1];

            if(dur > maxTime)
                continue;

            if(t + dur <= maxTime){
                t += dur;
                pq.offer(dur);
            } 
            else{
                if(!pq.isEmpty() && dur < pq.peek()){
                    t -= pq.poll();
                    t += dur;
                    pq.offer(dur);
                }
            }
        }


        return pq.size();
    }
}