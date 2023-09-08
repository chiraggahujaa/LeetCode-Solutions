class Solution {
    int n, k;
    HashMap<Character, Integer> map;
    public int characterReplacement(String s, int k) {
        this.n = s.length();
        this.k = k;
        this.map = new HashMap<>();

        int j = 0, res = 0;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(j<n && !isValid()){
                char ch1 = s.charAt(j);
                map.put(ch1, map.getOrDefault(ch1, 1)-1);
                j++;
            }

            res = Math.max(res, i-j+1);
        }

        return res;
    }
    public boolean isValid(){
        int max = getMostCommanFreq();
        int tot = getTotFreq();
        return tot - max <= k;
    }
    public int getMostCommanFreq(){
        int max = 0;
        for(Map.Entry<Character, Integer> e : map.entrySet())
            max = Math.max(max, e.getValue());
        return max;
    }
    public int getTotFreq(){
        int tot = 0;
        for(Map.Entry<Character, Integer> e : map.entrySet())
            tot += e.getValue();
        return tot;
    }
}