class Pair{
    int id, t;
    Pair(int id, int t){
        this.id = id;
        this.t = t;
    }
    public String toString(){
        return "("+id+" "+t+")";
    }
}
class Twitter {
    HashMap<Integer, List<Pair>> posts;
    HashMap<Integer, HashSet<Integer>> follows;
    int t=0;

    public Twitter() {
        this.posts = new HashMap<>();
        this.follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.computeIfAbsent(userId, y->new ArrayList<>()).add(new Pair(tweetId, t)); // O(1)
        t++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> a.t - b.t
        ); // min heap since we wanted to maintain top 10

        for(Pair p : posts.getOrDefault(userId, new ArrayList<>())){
            pq.offer(p);

            if(pq.size() > 10)
                    pq.poll();
        }
        
        for(int followerId : follows.getOrDefault(userId, new HashSet<>())){
            for(Pair p : posts.getOrDefault(followerId, new ArrayList<>())){
                pq.offer(p);

                if(pq.size() > 10)
                    pq.poll();
            }
        }

        // System.out.println(pq);

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.add(pq.poll().id);

        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, y->new HashSet<>()).add(followeeId); // O(1)
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId) && follows.get(followerId).contains(followeeId))
            follows.get(followerId).remove(followeeId); // O(1)
    }
}