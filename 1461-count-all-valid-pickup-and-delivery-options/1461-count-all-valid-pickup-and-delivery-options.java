class Solution {
    int mod = 1000000007;
    public int countOrders(int n) {
        return (int)f(n);
    }
    public long f(long n) {
        if(n == 1)
            return 1;

        long spaces = (n-1)*2 + 1;
        long res =  f(n-1) * sum(spaces); 
        return res % mod;
    }
    private long sum(long n){
        return n*(n+1)/2;
    }
}