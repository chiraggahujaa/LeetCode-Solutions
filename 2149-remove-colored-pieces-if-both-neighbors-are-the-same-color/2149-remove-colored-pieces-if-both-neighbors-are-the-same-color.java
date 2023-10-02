class Solution {
    public boolean winnerOfGame(String colors) {
        // make 2 priority queue
        // groups of A -> 3,1
        // groups of B -> 6

        // alice moves
        // A -> 2,1
        
        // bob moves
        // B -> 5

        // alice moves
        // can't => alice looses

        int n = colors.length();
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); // max heap

        int i=0;
        while(i<n){
            char ch = colors.charAt(i);
            int count = 0;
            while(i<n && ch == colors.charAt(i)){
                count++;
                i++;
            }
            if(ch == 'A')
                p.offer(count);
            else
                q.offer(count);
        }

        boolean aliceTurn = true;
        while(true){
            if(aliceTurn){
                if(p.isEmpty() || p.peek() < 3)
                    return false;
                p.offer(p.poll()-1);

                aliceTurn = false;
            }
            else{
                if(q.isEmpty() || q.peek() < 3)
                    return true;
                q.offer(q.poll()-1);

                aliceTurn = true;
            }
        }
    }
}