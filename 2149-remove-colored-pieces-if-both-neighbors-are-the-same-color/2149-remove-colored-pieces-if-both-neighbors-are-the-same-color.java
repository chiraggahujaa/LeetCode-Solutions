class Solution {
    public boolean winnerOfGame(String colors) {
        // we can maintain number of chance that alice have and number of chance that bob has.
        // if aliceChance <= bobChance -> false, else -> true

        // "ABBBBBBBAAA"
        // aliceChance = pos(1-2) + pos(3-2) = 0 + 1 = 1 --> pos() means take only postive, if negitive then 0
        // bobChance = pos(6-2) = 4

        // aliceChance <= bobChance -> false

        int n = colors.length();
        int aliceChance = 0, bobChance = 0;

        int i=0;
        while(i<n){
            char ch = colors.charAt(i);
            int count = 0;
            while(i<n && ch == colors.charAt(i)){
                count++;
                i++;
            }
            if(ch == 'A')
                aliceChance += Math.max(count-2, 0);
            else
                bobChance += Math.max(count-2, 0);
        }

        return aliceChance > bobChance;
    }
}