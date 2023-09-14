class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        Arrays.sort(hand);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int el : hand)
            map.put(el, map.getOrDefault(el, 0)+1);

        for(int i=0; i<n; i++){
            int el = hand[i];
            
            if(map.get(el) == 0)
                continue;
            
            for(int j=0; j<groupSize; j++){
                if(map.getOrDefault(el + j, 0) <= 0){
                    return false;
                }
                map.put(el + j, map.get(el + j)-1);
            }
        }

        return true;
    }
}