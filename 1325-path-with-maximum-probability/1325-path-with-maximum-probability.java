class Pair{
    int u;
    double prob;
    Pair(int u, double prob){
        this.u = u;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, List<Pair>> adj = new HashMap<>();
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.computeIfAbsent(u, y -> new ArrayList<>()).add(new Pair(v, prob));
            adj.computeIfAbsent(v, y -> new ArrayList<>()).add(new Pair(u, prob));
        }

        double[] res = new double[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                double val = b.prob - a.prob;
                if(val < 0) return -1;
                else if(val > 0) return 1;
                else return 0;
            }
        );

        Arrays.fill(res, 0.0);
        res[start_node] = 1.0;
        pq.offer(new Pair(start_node, 1));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int u = p.u;
            double prob1 = p.prob;

            for(Pair p2 : adj.getOrDefault(u, new ArrayList<>())){
                int v = p2.u;
                double prob2 = p2.prob;

                System.out.println(u + " " + v + " " + prob1 + " " + prob2);

                if(prob1 * prob2 > res[v]){
                    res[v] = prob1 * prob2;
                    pq.offer(new Pair(v, res[v]));
                }
            }
        }

        return res[end_node];
    }
}