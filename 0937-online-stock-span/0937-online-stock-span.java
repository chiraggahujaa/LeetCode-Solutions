class Pair{
    int val, cnt;
    Pair(int val, int cnt){
        this.val = val;
        this.cnt = cnt;
    }
}
class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;

        while(!st.isEmpty() && price >= st.peek().val)
            count += st.pop().cnt;

        st.push(new Pair(price, count));
        return count;
    }
}