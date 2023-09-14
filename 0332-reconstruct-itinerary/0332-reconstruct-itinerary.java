class Solution {
    int resLen;
    List<String> res;
    HashMap<String, List<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        this.resLen = tickets.size() + 1;
        this.res = new ArrayList<>();
        
        Collections.sort(tickets, 
            (a,b) -> a.get(0).compareTo(b.get(0)) == 0 ?
                     a.get(1).compareTo(b.get(1)) :
                     a.get(0).compareTo(b.get(0))
        );

        this.adj = new HashMap<>();
        for(List<String> ticket : tickets){
            String a = ticket.get(0);
            String b = ticket.get(1);

            adj.computeIfAbsent(a, x-> new ArrayList<>()).add(b);
        }

        dfs("JFK");
        return res;
    }
    public boolean dfs(String u){
        res.add(u);
        if(res.size() == resLen)
                return true;

        List<String> list = adj.getOrDefault(u, new ArrayList<>());
        for(int i=0; i<list.size(); i++){
            String v = list.remove(i);
            
            if(dfs(v))
                return true;
            
            list.add(i, v);
        }

        res.remove(res.size()-1);
        return false;
    }
}