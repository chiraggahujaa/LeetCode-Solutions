class Solution {
    public boolean isHappy(int n) {
        HashSet<Long> set = new HashSet<>();

        while(true){
            long sqSum = getSqSum(n);

            if(sqSum == 1)
                break;

            if(set.contains(sqSum))
                return false;
            
            set.add(sqSum);
            n = (int)sqSum;
        }

        return true;
    }
    public long getSqSum(long num){
        long sum = 0;

        while(num > 0){
            long digit = num % 10;
            sum += digit * digit;
            num/=10;
        }

        return sum;
    }
}