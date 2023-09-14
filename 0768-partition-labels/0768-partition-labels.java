class Pair{
    int i, j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
    public String toString(){
        return "("+i+" "+j+")";
    }
}
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Pair[] pairs = new Pair[26];

        for(int i=0; i<n; i++){
            int ind = s.charAt(i) - 'a';
            
            if(pairs[ind] == null)  
                pairs[ind] = new Pair(i, i);
            else
                pairs[ind].j = i;
        }

        Arrays.sort(pairs, (a,b) -> {
            if(a == null)
                return 1;
            else if(b == null)
                return -1;
            else
                return a.i==b.i ? a.j-b.j : a.i-b.i;
        });

        // System.out.println(Arrays.toString(pairs));

        List<Integer> list = new ArrayList<>();
        int min = -1, max = -1;

        for(Pair p : pairs){
            if(p == null)
                continue;

            int i = p.i, j = p.j;

            if(min == -1 && max == -1){
                min = i;
                max = j;
                continue;
            }
            
            if((i>=min && i<=max) || (j>=min && j<=max)){
                min = Math.min(i, min);
                max = Math.max(j, max);
            }
            else{
                int size = max - min + 1;
                list.add(size);

                min = i;
                max = j;
            }

            // System.out.println(min + " " + max);
        }

        list.add(max-min+1);
        return list;
    }
}